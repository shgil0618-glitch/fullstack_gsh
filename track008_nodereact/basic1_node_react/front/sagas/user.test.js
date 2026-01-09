// npx jest sagas/user.test.js
import { call, put } from 'redux-saga/effects';
import {
  login, signUp, loadUsers, logout, updateNickname, deleteUser,
  loginApi, signUpApi, loadUsersApi, logoutApi, updateNicknameApi, deleteUserApi
} from '../sagas/user';

import {
  LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,
  LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,
  SIGN_UP_REQUEST, SIGN_UP_SUCCESS, SIGN_UP_FAILURE,
  LOAD_USERS_REQUEST, LOAD_USERS_SUCCESS, LOAD_USERS_FAILURE,
  UPDATE_NICKNAME_REQUEST, UPDATE_NICKNAME_SUCCESS, UPDATE_NICKNAME_FAILURE,
  DELETE_USER_REQUEST, DELETE_USER_SUCCESS, DELETE_USER_FAILURE
} from '../reducers/user';

describe('user saga', () => {

  // ---------------- 로그인 ----------------
  it('login saga success and failure', () => {
    const action = { type: LOG_IN_REQUEST, data: { email:'z@z', password:'z' } };
    const gen = login(action);

    // ✅ 성공
    expect(gen.next().value).toEqual(call(loginApi, action.data));
    const apiResponse = { APP_USER_ID:3, EMAIL:'z@z', NICKNAME:'zzz' };
    expect(gen.next({ data: apiResponse }).value).toEqual(
      put({ type: LOG_IN_SUCCESS, data: { id:3, email:'z@z', nickname:'zzz' } })
    );

    // 🔴 실패
    const genFail = login(action);
    expect(genFail.next().value).toEqual(call(loginApi, action.data));
    const error = new Error('Invalid credentials');
    expect(genFail.throw(error).value).toEqual(
      put({ type: LOG_IN_FAILURE, error: error.message })
    );
  });

  // ---------------- 회원가입 ----------------
  it('signUp saga success and failure', () => {
    const action = { type: SIGN_UP_REQUEST, data: { email:'a@a', password:'123', nickname:'aaa' } };
    const gen = signUp(action);

    // ✅ 성공
    expect(gen.next().value).toEqual(call(signUpApi, action.data));
    expect(gen.next().value).toEqual(put({ type: SIGN_UP_SUCCESS }));

    // 🔴 실패
    const genFail = signUp(action);
    expect(genFail.next().value).toEqual(call(signUpApi, action.data));
    const error = new Error('Email already exists');
    expect(genFail.throw(error).value).toEqual(
      put({ type: SIGN_UP_FAILURE, error: error.message })
    );
  });

  // ---------------- 로그아웃 ----------------
  it('logout saga success and failure', () => {
    const action = { type: LOG_OUT_REQUEST };
    const gen = logout(action);

    // ✅ 성공
    expect(gen.next().value).toEqual(call(logoutApi));
    expect(gen.next().value).toEqual(put({ type: LOG_OUT_SUCCESS }));

    // 🔴 실패
    const genFail = logout(action);
    expect(genFail.next().value).toEqual(call(logoutApi));
    const error = new Error('Logout failed');
    expect(genFail.throw(error).value).toEqual(
      put({ type: LOG_OUT_FAILURE, error: error.message })
    );
  });

  // ---------------- 사용자 조회 ----------------
  it('loadUsers saga success and failure', () => {
    const action = { type: LOAD_USERS_REQUEST };
    const gen = loadUsers(action);

    // ✅ 성공
    expect(gen.next().value).toEqual(call(loadUsersApi));
    const apiResponse = [{ id:1, email:'a@a', nickname:'aaa' }];
    expect(gen.next({ data: apiResponse }).value).toEqual(
      put({ type: LOAD_USERS_SUCCESS, data: apiResponse })
    );

    // 🔴 실패
    const genFail = loadUsers(action);
    expect(genFail.next().value).toEqual(call(loadUsersApi));
    const error = new Error('DB connection error');
    expect(genFail.throw(error).value).toEqual(
      put({ type: LOAD_USERS_FAILURE, error: error.message })
    );
  });

  // ---------------- 닉네임 수정 ----------------
  it('updateNickname saga success and failure', () => {
    const action = { type: UPDATE_NICKNAME_REQUEST, data: { id:1, nickname:'newName' } };
    const gen = updateNickname(action);

    // ✅ 성공
    expect(gen.next().value).toEqual(call(updateNicknameApi, action.data));
    expect(gen.next().value).toEqual(put({ type: UPDATE_NICKNAME_SUCCESS }));

    // 🔴 실패
    const genFail = updateNickname(action);
    expect(genFail.next().value).toEqual(call(updateNicknameApi, action.data));
    const error = new Error('Update failed');
    expect(genFail.throw(error).value).toEqual(
      put({ type: UPDATE_NICKNAME_FAILURE, error: error.message })
    );
  });

  // ---------------- 사용자 삭제 ----------------
  it('deleteUser saga success and failure', () => {
    const action = { type: DELETE_USER_REQUEST, data: 1 };
    const gen = deleteUser(action);

    // ✅ 성공
    expect(gen.next().value).toEqual(call(deleteUserApi, action.data));
    expect(gen.next().value).toEqual(put({ type: DELETE_USER_SUCCESS }));

    // 🔴 실패
    const genFail = deleteUser(action);
    expect(genFail.next().value).toEqual(call(deleteUserApi, action.data));
    const error = new Error('Delete failed');
    expect(genFail.throw(error).value).toEqual(
      put({ type: DELETE_USER_FAILURE, error: error.message })
    );
  });

});

/*
//  npx  jest  sagas/user.test.js
import{call, put}  from 'redux-saga/effects';
import {
    login, signUp, loadUsers, logout, updateNickname, deleteUser,
    loginApi, signUpApi, loadUsersApi, logoutApi, updateNicknameApi, deleteUserApi
} from '../sagas/user';

import  reducer, {
    initialState ,   LOG_IN_REQUEST, LOG_IN_SUCCESS, LOG_IN_FAILURE,
    LOG_OUT_REQUEST, LOG_OUT_SUCCESS, LOG_OUT_FAILURE,  SIGN_UP_REQUEST, SIGN_UP_SUCCESS,  SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST, LOAD_USERS_SUCCESS, LOAD_USERS_FAILURE,
    UPDATE_NICKNAME_REQUEST,  UPDATE_NICKNAME_SUCCESS, UPDATE_NICKNAME_FAILURE,
    DELETE_USER_REQUEST, DELETE_USER_SUCCESS, DELETE_USER_FAILURE
} from '../reducers/user';
 
describe( 'user saga' ,  ()=>{
    it( 'login success'   , ()=>{
        const action = {type: LOG_IN_REQUEST , data: {email:'z@z' , password:'z'}};
        const gen = login(action);
        expect(gen.next().value).toEqual(call(loginApi , action.data));
        
        const  apiResponse = {APP_USER_ID:1 , EMAIL:'z@z' , NICKNAME:'zzz'};  // 테스트데이터
        expect( gen.next( {data:apiResponse}  ).value  ).toEqual(
            put({
                type: LOG_IN_SUCCESS,
                data:{id:1 , email:'z@z' , nickname:'zzz' }
            })
        ); 
    }); 
    /////
    it( 'logout success'   , ()=>{
        const action = {type: LOG_OUT_REQUEST };  //#1. 액션타입
        const gen = logout(action); // #2. logout  기능확인

        expect(gen.next().value).toEqual(call(logoutApi));  // #3. 결과물확인 -
        expect(gen.next({}).value).toEqual(put({ type: LOG_OUT_SUCCESS }));   

        const  error = { response : {data : '로그아웃 실패'}};  // 테스트데이터  
        expect( gen.throw(error).value  ).toEqual( put({type: LOG_OUT_FAILURE, error:'로그아웃 실패' }) );  //실패
    }); 
    //////
    it( 'signup success'   , ()=>{
        const action = {type: SIGN_UP_REQUEST , data:{ email:'z@z' , password:'z' }};  //#1. 액션타입
        const gen = signUp(action);             // #2. singnUp  기능확인

        expect(gen.next().value).toEqual(call(signUpApi , action.data));  // #3. 결과물확인  
        expect(gen.next({}).value).toEqual(put({ type: SIGN_UP_SUCCESS }));   

        const  error = { response : {data : '이미 존재하는 이메일'}};  // 테스트데이터  
        expect( gen.throw(error).value  ).toEqual( put({type: SIGN_UP_FAILURE, error:'이미 존재하는 이메일' }) );  //실패
    }); 

   //////
    it( 'loadUsers success'   , ()=>{
        const action = {type: LOAD_USERS_REQUEST };  // #1. 액션타입
        const gen = loadUsers(action);               // #2. loadUsers  기능확인

        expect(gen.next().value).toEqual(call(loadUsersApi));  // #3. 결과물확인  

        const fakeUers = [{APP_USER_ID:1 , EMAIL:'z@z' , NICKNAME:'zzz'}]

        expect(gen.next({data : fakeUers}).value)
            .toEqual(put({ type: LOAD_USERS_SUCCESS, data:[ {id:1, email:'z@z' , nickname:'zzz'}]}));   

        const  error = { response : {data : '조회 실패'}};  // 테스트데이터  
        expect( gen.throw(error).value  ).toEqual( put({type: LOAD_USERS_FAILURE, error:'조회 실패' }) );  //실패
    }); 
 
   //////
    it( 'updateNickname success'   , ()=>{
        const action = {type: UPDATE_NICKNAME_REQUEST , data:{  id:1, nickname:'new'} };  // #1. 액션타입
        const gen = updateNickname(action);               // #2. loadUsers  기능확인

        expect(gen.next().value).toEqual(call(updateNicknameApi , action.data));  // #3. 결과물확인  localhost:3065/
        expect(gen.next({}).value).toEqual(put({ type: UPDATE_NICKNAME_SUCCESS, data:  {id:1,  nickname:'new'} }));   

        const  error = { response : {data : '수정 실패'}};  // 테스트데이터  
        expect( gen.throw(error).value  ).toEqual( put({type: UPDATE_NICKNAME_FAILURE, error:'수정 실패' }) );  //실패
    }); 
  //////
    it( 'deleteUser success'   , ()=>{
        const action = {type: DELETE_USER_REQUEST , data:{  id:1 } };  // #1. 액션타입
        const gen = deleteUser(action);               // #2. loadUsers  기능확인

        expect(gen.next().value).toEqual(call(deleteUserApi , action.data.id));  // #3. 결과물확인  localhost:3065/
        expect(gen.next({}).value).toEqual(put({ type: DELETE_USER_SUCCESS, data:  {id:1} }));   

        const  error = { response : {data : '존재안함'}};  // 테스트데이터  
        expect( gen.throw(error).value  ).toEqual( put({type: DELETE_USER_FAILURE, error:'존재안함' }) );  //실패
    }); 
});

*/