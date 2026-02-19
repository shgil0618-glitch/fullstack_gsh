package com.thejoa703.service;

import com.thejoa703.dao.EventDao; // 기존 Mapper 인터페이스를 DAO로 명칭 변경 가능
import com.thejoa703.dto.*;
import com.thejoa703.service.EventService;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EventServiceImpl implements EventService {
    
    private EventDao eventDao = new EventDao(); // Servlet 방식에서는 직접 생성 또는 싱글톤
    private final String PRESET_PHONE = "01012345678"; // 1등 사전 지정 번호

    @Override
    public Map<String, Object> joinEvent(String phoneNumber) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();

        // 1. 중복 참여 확인 (휴대폰 번호 기준)
        int duplicateCount = eventDao.checkDuplicatePhone(phoneNumber);
        if (duplicateCount > 0) {
            resultMap.put("status", "FAIL");
            resultMap.put("message", "이미 참여하신 번호입니다.");
            return resultMap;
        }

        // 2. 참가자 등록 (DB 시퀀스를 통해 ENTRY_ORDER 획득)
        ParticipantDto participant = new ParticipantDto();
        participant.setPhoneNumber(phoneNumber);
        participant.setEventId(1); // 예시 이벤트 ID
        eventDao.insertParticipant(participant); 
        
        int myOrder = participant.getEntryOrder();
        int winRank = 0; // 0: 꽝
        String winReason = "";

        // 3. 당첨 논리 설계 (과제 조건 반영)
        // 조건 1: 특정 휴대폰 번호 1등 사전 지정
        if (phoneNumber.equals(PRESET_PHONE)) {
            winRank = 1;
            winReason = "PRESET";
        } 
        // 조건 2: 2등은 참가자 번호 2,000 ~ 7,000번 사이에서 선정 (총 5명)
        else if (myOrder >= 2000 && myOrder <= 7000) {
            if (eventDao.getCurrentWinnerCount(2) < 5) { // 현재 2등 당첨자가 5명 미만인지 체크
                if (new Random().nextInt(100) < 5) { // 범위 내 확률 부여 예시
                    winRank = 2;
                    winReason = "RANGE_2000_7000";
                }
            }
        }
        // 조건 3: 3등은 참가자 번호 1,000 ~ 8,000번 사이에서 선정 (총 44명)
        else if (myOrder >= 1000 && myOrder <= 8000) {
            if (eventDao.getCurrentWinnerCount(3) < 44) {
                if (new Random().nextInt(100) < 10) {
                    winRank = 3;
                    winReason = "RANGE_1000_8000";
                }
            }
        }
        // 조건 4: 4등 전체 범위 내 배정 (총 950명)
        else {
            if (eventDao.getCurrentWinnerCount(4) < 950) {
                if (new Random().nextInt(100) < 15) {
                    winRank = 4;
                    winReason = "RANDOM_DISTRIBUTION";
                }
            }
        }

        // 4. 로또 번호 발번
        String lottoNum = generateLottoNumber(winRank);
        LottoNumberDto lottoDto = new LottoNumberDto();
        lottoDto.setParticipantId(participant.getParticipantId());
        lottoDto.setLottoNumber(lottoNum);
        eventDao.insertLottoNumber(lottoDto);

        // 5. 당첨 시 WINNER 테이블 기록
        if (winRank > 0) {
            WinnerDto winner = new WinnerDto();
            winner.setParticipantId(participant.getParticipantId());
            winner.setWinRank(winRank);
            winner.setWinReason(winReason);
            eventDao.insertWinner(winner);
        }

        // 6. 결과 확인 초기 테이블 생성
        eventDao.insertInitialResultCheck(participant.getParticipantId());

        resultMap.put("status", "SUCCESS");
        resultMap.put("lottoNumber", lottoNum);
        return resultMap;
    }

    // 로또 번호 생성 로직 (1등은 6자리 일치 등 조건부 생성)
    private String generateLottoNumber(int rank) {
        if (rank == 1) return "777777"; // 예시: 1등은 모두 동일 번호
        return String.format("%06d", new Random().nextInt(1000000));
    }

    @Override
    public Map<String, Object> checkWinningResult(String phoneNumber) throws Exception {
        // 결과 확인 횟수(CHECK_COUNT)에 따른 로직 분기
        // 1회차: 등수 공개 / 2회차 이상: 당첨여부만
        return eventDao.getWinningResultWithCountUpdate(phoneNumber);
    }

    @Override
    public void sendRemindSmsToUnchecked() throws Exception {
        // 발표 10일 후 미확인자 추출 및 SMS 발송 로직
    }
}