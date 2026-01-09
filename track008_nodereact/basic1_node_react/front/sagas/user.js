/**
 * sagas/user.js
 * ----------------------------------------------
 * ✅ 사용자 관련 비동기 작업을 처리하는 saga
 * - 로그인, 로그아웃, 회원가입, 사용자 조회, 닉네임 수정, 사용자 삭제
 * - axios로 API를 호출 → 성공/실패에 따라 reducer로 액션 전달
 */
import { all, fork , call, put, takeLatest} from 'redux-saga/effects'; 
import axios from 'axios';  
import  { 
    LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,
    LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,
    SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST, LOAD_USERS_SUCCESS, LOAD_USERS_FAILURE,
    UPDATE_NICKNAME_REQUEST, UPDATE_NICKNAME_SUCCESS, UPDATE_NICKNAME_FAILURE,
    DELETE_USER_REQUEST, DELETE_USER_SUCCESS, DELETE_USER_FAILURE
} from '../reducers/user'; 

// ✅ axios 클라이언트 기본설정
const client = axios.create({
    baseURL: 'http://localhost:3065',
    withCredentials: true,  
});

// ------------------ 회원가입 ----------------
export function signUpApi(data){
    return client.post('/user/register', data);
}
export function* signUp(action){
    try{
        yield call(signUpApi, action.data);
        yield put({ type: SIGN_UP_SUCCESS });
    }catch(err){
        yield put({ type: SIGN_UP_FAILURE, error: err.response?.data || err.message });
    }
}
function* watchSignUp(){
    yield takeLatest(SIGN_UP_REQUEST, signUp);
}

// ------------------ 로그인 ------------------
export function loginApi(data){
    return client.post('/user/login', data);
}
export function* login(action){
    try{
        const result = yield call(loginApi, action.data);
        const user ={
            id : result.data.APP_USER_ID,
            email: result.data.EMAIL ,
            nickname: result.data.NICKNAME
        };
        yield put({ type: LOG_IN_SUCCESS, data:user }); // ✅ 로그인 성공 시 사용자 데이터 전달
    }catch(err){
        yield put({ type: LOG_IN_FAILURE, error: err.response?.data || err.message });
    }
}
function* watchLogin(){
    yield takeLatest(LOG_IN_REQUEST, login);
}

// ------------------ 로그아웃 -----------------
export function logoutApi(){
    return client.post('/user/logout');
}
export function* logout(){
    try{
        yield call(logoutApi);
        yield put({ type: LOG_OUT_SUCCESS });
    }catch(err){
        yield put({ type: LOG_OUT_FAILURE, error: err.response?.data || err.message });
    }
}
function* watchLogout(){
    yield takeLatest(LOG_OUT_REQUEST, logout);
}

// ------------------ 전체 사용자 조회 ----------
export function loadUsersApi(){
    return client.get('/user');
}
export function* loadUsers(){
    try{
        const result = yield call(loadUsersApi);
        yield put({ type: LOAD_USERS_SUCCESS, data: result.data });
    }catch(err){
        yield put({ type: LOAD_USERS_FAILURE, error: err.response?.data || err.message });
    }
}
function* watchLoadUsers(){
    yield takeLatest(LOAD_USERS_REQUEST, loadUsers);
}

// ------------------ 닉네임 수정 --------------
export function updateNicknameApi(data){
    return client.patch(`/user/${data.id}/nickname`, { nickname: data.nickname });
}
export function* updateNickname(action){
    try{
        yield call(updateNicknameApi, action.data);
        yield put({ type: UPDATE_NICKNAME_SUCCESS });
    }catch(err){
        yield put({ type: UPDATE_NICKNAME_FAILURE, error: err.response?.data || err.message });
    }
}
function* watchUpdateNickname(){
    yield takeLatest(UPDATE_NICKNAME_REQUEST, updateNickname);
}

// ------------------ 사용자 삭제 --------------
export function deleteUserApi(id){
    return client.delete(`/user/${id}`);
}
export function* deleteUser(action){
    try{
        yield call(deleteUserApi, action.data);
        yield put({ type: DELETE_USER_SUCCESS });
    }catch(err){
        yield put({ type: DELETE_USER_FAILURE, error: err.response?.data || err.message });
    }
}
function* watchDeleteUser(){
    yield takeLatest(DELETE_USER_REQUEST, deleteUser);
}

// ------------------ root saga ----------------
export default function* userSaga(){
    yield all([
        fork(watchSignUp),
        fork(watchLogin),
        fork(watchLogout),
        fork(watchLoadUsers),
        fork(watchUpdateNickname),
        fork(watchDeleteUser),
    ]);
}