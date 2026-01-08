/** 
 * reducers/index.js
 * -------------------------------------------------
 * 루트 리듀서(RootReducer) 설정파일
 * - 여러개의 리듀서를 하나로 합쳐 Redux 스토어에 전달
 * - 현재는 user 리듀서만 포함
 */  

import {combineReducers} from 'redux'; // 여러개의 리듀서를 하나로 합치는 Redux 함수
import user from './user';             // 사용자 관련상태를 관리하는 user 리듀서
// import post from './post';          

const RootReducer = combineReducers({
    user, //post
});
export default RootReducer;




