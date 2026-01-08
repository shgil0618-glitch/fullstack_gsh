// npx jest reducers/user.test.js

import reducer, {
    initialState,
    LOG_IN_REQUEST,LOG_IN_SUCCESS,LOG_IN_FAILURE,
    LOG_OUT_REQUEST,LOG_OUT_SUCCESS,LOG_OUT_FAILURE,
    SIGN_UP_REQUEST,SIGN_UP_SUCCESS,SIGN_UP_FAILURE,
    LOAD_USERS_REQUEST,LOAD_USERS_SUCCESS,LOAD_USERS_FAILURE,
    UPDATE_NICKNAME_REQUEST,UPDATE_NICKNAME_SUCCESS,UPDATE_NICKNAME_FAILURE,
    DELETE_USER_REQUEST,DELETE_USER_SUCCESS,DELETE_USER_FAILURE
} from './user';

describe('user reducer', ()=>{

    // 🟢 로그인(Login)
    it('should handle LOG_IN_REQUEST', ()=>{ 
        const state = reducer(initialState, {type:LOG_IN_REQUEST});
        // return {...state, isLoading:true, error:null}
        expect(state.isLoading).toBe(true);
    });

    it('should handle LOG_IN_SUCCESS', ()=>{ 
        const fakeUser = {id:1, email:'1@1', nickname:'first'};
        const state = reducer(initialState, {type:LOG_IN_SUCCESS, data:fakeUser});
        // return {...state, isLoading:false, me:action.data}
        expect(state.me).toBe(fakeUser);
    });

    it('should handle LOG_IN_FAILURE', ()=>{ 
        const state = reducer(initialState, {type:LOG_IN_FAILURE, error:'로그인 실패'});
        // return {...state, isLoading:false, error:action.error}
        expect(state.error).toBe('로그인 실패');
        expect(state.isLoading).toBe(false);
    });

    // 🔴 로그아웃(Logout)
    it('should handle LOG_OUT_REQUEST', ()=>{ 
        const state = reducer(initialState, {type:LOG_OUT_REQUEST});
        // return {...state, isLoading:true, error:null}
        expect(state.isLoading).toBe(true);
        expect(state.error).toBe(null);
    });

    it('should handle LOG_OUT_SUCCESS', ()=>{ 
        const loggedInState = {...initialState, me:{id:1, email:'1@1', nickname:'first'}};
        const state = reducer(loggedInState, {type:LOG_OUT_SUCCESS});
        // return {...state, isLoading:false, me:null}
        expect(state.me).toBe(null);
        expect(state.isLoading).toBe(false);
    });

    it('should handle LOG_OUT_FAILURE', ()=>{ 
        const state = reducer(initialState, {type:LOG_OUT_FAILURE, error:'로그아웃 실패'});
        // return {...state, isLoading:false, error:action.error}
        expect(state.error).toBe('로그아웃 실패');
        expect(state.isLoading).toBe(false);
    });

    // 🟢 회원가입(Sign Up)
    it('should handle SIGN_UP_REQUEST', ()=>{ 
        const state = reducer(initialState, {type:SIGN_UP_REQUEST});
        // return {...state, isLoading:true, error:null}
        expect(state.isLoading).toBe(true);
        expect(state.error).toBe(null);
    });

    it('should handle SIGN_UP_SUCCESS', ()=>{ 
        const state = reducer(initialState, {type:SIGN_UP_SUCCESS});
        // return {...state, isLoading:false, signUpDone:true}
        expect(state.signUpDone).toBe(true);
        expect(state.isLoading).toBe(false);
    });

    it('should handle SIGN_UP_FAILURE', ()=>{ 
        const state = reducer(initialState, {type:SIGN_UP_FAILURE, error:'회원가입 실패'});
        // return {...state, isLoading:false, error:action.error}
        expect(state.error).toBe('회원가입 실패');
        expect(state.isLoading).toBe(false);
    });

    // 📋 사용자 목록 불러오기 (Load Users)
    it('should handle LOAD_USERS_REQUEST', ()=>{ 
        const state = reducer(initialState, {type:LOAD_USERS_REQUEST});
        // return {...state, isLoading:true, error:null}
        expect(state.isLoading).toBe(true);
    });

    it('should handle LOAD_USERS_SUCCESS', ()=>{ 
        const fakeUsers = [
            {id:1, email:'1@1', nickname:'first'},
            {id:2, email:'2@2', nickname:'second'}
        ];
        const state = reducer(initialState, {type:LOAD_USERS_SUCCESS, data:fakeUsers});
        // return {...state, isLoading:false, users:action.data}
        expect(state.users).toEqual(fakeUsers);
        expect(state.isLoading).toBe(false);
    });

    it('should handle LOAD_USERS_FAILURE', ()=>{ 
        const state = reducer(initialState, {type:LOAD_USERS_FAILURE, error:'목록 불러오기 실패'});
        // return {...state, isLoading:false, error:action.error}
        expect(state.error).toBe('목록 불러오기 실패');
        expect(state.isLoading).toBe(false);
    });

    // ✏️ 닉네임 수정(Update Nickname)
    it('should handle UPDATE_NICKNAME_REQUEST', ()=>{ 
        const state = reducer(initialState, {type:UPDATE_NICKNAME_REQUEST});
        // return {...state, isLoading:true, error:null}
        expect(state.isLoading).toBe(true);
    });

    it('should handle UPDATE_NICKNAME_SUCCESS', ()=>{ 
        const prevState = {
            ...initialState,
            me: {id:1, email:'1@1', nickname:'old'},
            users: [{id:1, email:'1@1', nickname:'old'}]
        };
        const updated = {id:1, nickname:'new'};
        const state = reducer(prevState, {type:UPDATE_NICKNAME_SUCCESS, data:updated});
        // return {...state, isLoading:false, me:{...me,nickname:new}, users:[...users with updated nickname]}
        expect(state.me.nickname).toBe('new');
        expect(state.users[0].nickname).toBe('new');
        expect(state.isLoading).toBe(false);
    });

    it('should handle UPDATE_NICKNAME_FAILURE', ()=>{ 
        const state = reducer(initialState, {type:UPDATE_NICKNAME_FAILURE, error:'닉네임 수정 실패'});
        // return {...state, isLoading:false, error:action.error}
        expect(state.error).toBe('닉네임 수정 실패');
        expect(state.isLoading).toBe(false);
    });

    // ❌ 사용자 삭제(Delete User)
    it('should handle DELETE_USER_REQUEST', ()=>{ 
        const state = reducer(initialState, {type:DELETE_USER_REQUEST});
        // return {...state, isLoading:true, error:null}
        expect(state.isLoading).toBe(true);
    });

    it('should handle DELETE_USER_SUCCESS', ()=>{ 
        const prevState = {
            ...initialState,
            me: {id:1, email:'1@1', nickname:'first'},
            users: [
                {id:1, email:'1@1', nickname:'first'},
                {id:2, email:'2@2', nickname:'second'}
            ]
        };
        const state = reducer(prevState, {type:DELETE_USER_SUCCESS, data:{id:1}});
        // return {...state, isLoading:false, users:users.filter(u=>u.id!==id), me:null if deleted self}
        expect(state.me).toBe(null); 
        expect(state.users).toEqual([{id:2, email:'2@2', nickname:'second'}]);
        expect(state.isLoading).toBe(false);
    });

    it('should handle DELETE_USER_FAILURE', ()=>{ 
        const state = reducer(initialState, {type:DELETE_USER_FAILURE, error:'삭제 실패'});
        // return {...state, isLoading:false, error:action.error}
        expect(state.error).toBe('삭제 실패');
        expect(state.isLoading).toBe(false);
    });
});