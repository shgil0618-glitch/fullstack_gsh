package com.thejoa703.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.thejoa703.mybatis.SqlConfig; // MyBatis 설정 클래스 가정
import com.thejoa703.dto.*;
import java.util.Map;


public class EventDao {
    private SqlSessionFactory sqlSessionFactory = SqlConfig.getSqlSessionFactory();

    // 참가자 등록
    public int insertParticipant(ParticipantDto dto) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.insert("com.thejoa703.mapper.EventMapper.insertParticipant", dto);
        }
    }

    // 현재 특정 등수의 당첨자 수 확인 (당첨 인원 제한 로직용)
    public int getCurrentWinnerCount(int rank) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.thejoa703.mapper.EventMapper.getCurrentWinnerCount", rank);
        }
    }

    // 당첨 결과 저장
    public int insertWinner(WinnerDto dto) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            return session.insert("com.thejoa703.mapper.EventMapper.insertWinner", dto);
        }
    }

    // 휴대폰 번호로 결과 및 확인 횟수 조회
    public Map<String, Object> getWinningResult(String phoneNumber) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.thejoa703.mapper.EventMapper.getWinningResult", phoneNumber);
        }
    }
}