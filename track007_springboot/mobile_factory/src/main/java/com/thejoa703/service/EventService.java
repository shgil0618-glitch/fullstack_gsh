package com.thejoa703.service;

import com.thejoa703.dto.ParticipantDto;
import com.thejoa703.dto.LottoNumberDto;
import com.thejoa703.dto.WinnerDto;
import java.util.Map;

public interface EventService {
    // 이벤트 참가 신청 및 당첨 처리 (핵심 로직)
    Map<String, Object> joinEvent(String phoneNumber) throws Exception;
    
    // 결과 확인 및 횟수 업데이트
    Map<String, Object> checkWinningResult(String phoneNumber) throws Exception;
    
    // 발표 10일 후 미확인자 문자 발송 대상 조회
    void sendRemindSmsToUnchecked() throws Exception;
}