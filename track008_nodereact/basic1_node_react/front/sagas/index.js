/**
 * saga/index.js
 * -----------------------------------------------
 * ※ 루트 사가(rootSaga) 설정 파일 
 * - 모든 개별 saga(userSage 등)를 합쳐서 실행
 * - Redux-Saga의 all, fork를 사용해 병렬 실행
 */

import { all, fork , call, put, takeLatest} from 'redux-saga/effects'; // ✅  saga 기본 함수들
import axios from 'axios';      // ✅ HTTP요청 라이브러리
import  reducer, {
    initialState , 
    LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,
    LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,
    SIGN_UP_REQUEST, SIGN_UP_SUCCESS,  SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST, LOAD_USERS_SUCCESS, LOAD_USERS_FAILURE,
    UPDATE_NICKNAME_REQUEST,  UPDATE_NICKNAME_SUCCESS, UPDATE_NICKNAME_FAILURE,
    DELETE_USER_REQUEST, DELETE_USER_SUCCESS, DELETE_USER_FAILURE
} from '../reducer/user';        // ✅ 액션타입 불러오기


// 루트 사가 생성
export default function* rootSaga(){
    yield all([
        fork(userSaga), // ✅ userSaga를 병렬실행 배열[]
    ]);
}