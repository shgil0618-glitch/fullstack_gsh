// components/AppLayout.js
// 필요 라이브러리
import { Layout, Menu, Input, Row, Col, Drawer, Button, Grid } from "antd"; // 컴포넌트 : Drawer(햄버거)
import { MenuOutlined, SearchOutlined } from "@ant-design/icons"; // 아이콘
import Link from "next/link"; // 페이지 이동 링크
import { useSelector, useDispatch } from "react-redux"; // 리듀서 상태관리 (useSelector: reducer 가져오기, useDispatch)
import axios from "../api/axios"; // boot + access Token
import { logout, loginSuccess } from "../reducers/authReducer"; // 액션 - 로그인, 로그아웃
import { useRouter } from "next/router";
import { useEffect, useState } from "react"; // view 상태관리(이벤트, 변수)

const { Header, Content } = Layout; // 페이지 전체구성(Header, Content)
const { useBreakpoint } = Grid; // 반응형 

// 로그인 보호가 필요한 경로 정의
const protectRouter = ["/mypage", "/posts/new", "/profile"];

// 새로고침
function AppLayout({children, initialUser}){
    // code
    const {user}   = useSelector((state)=>state.auth); // store - redux 가져오기
    const dispatch = useDispatch(); // 이벤트 발생시 store에 알림
    const router   = useRouter(); // 이동 - 경로바꾸기
    const screens   = useBreakpoint(); // 반응형 화면

    const [drawerOpen, setDrawerOpen] = useState(false); // 햄버거 열림 - false
    const [searchValue, setSearchValue] = useState("");

    // 로그인 - 새로고침, 유저정보
    useEffect(()=>{
        console.log(user);
        // initialUser 존재 해야하고, user가 없으면, initialUser 안에 nickname이 있다면
        // 서버에서 초기사용자 정보가 있고 reducer에서는 아직 유저가 없다면
        if(initialUser && !user && initialUser.nickname){
            dispatch(loginSuccess({user:initialUser})); // loginSuccess 액션실행, 로그인 성공 시 user 상태 업데이트
        }
    }, [initialUser, user, dispatch]);// [] : 특정값이 변경 될 때 안쪽의 {} 콜백함수를 실행

    // /auth/me(마이페이지), /login(로그인)
    useEffect(()=>{
        // initialUser 없고, user 도 없다
        if(!user && !initialUser && protectRouter.includes(router.pathname)){
            // 서버에 현재 로그인 된 사용자 정보요청
            axios.get("/auth/me")
                 .then((res)=>{
                    if(res.data && res.data.nickname){
                        dispatch(loginSuccess({user:res.data}));
                    }else{
                        dispatch(logout());
                        router.replace("/login");
                    }
                 })
                 .catch(()=>{
                    dispatch(logout());
                    router.replace("/login"); // 주소표시창줄 바꿈
                 });
        }
    }, [user, initialUser, dispatch, router.pathname]);

    // 로그아웃
    const handleLogout = async()=>{
        try{
            await axios.post("/auth/logout");
            if(typeof window !== "undefined"){
                localStorage.removeItem("accessToken");
            }
            dispatch(logout());
            router.replace("/login");
        }catch(err){
            console.error("로그아웃 실패 : ", err);
            dispatch(logout());
            router.replace("/login");
        }
    };

    // 검색 실행
    const onSearch = (value)=>{
        if(value){
            // 백틱(`)으로 수정하여 변수 치환이 가능하게 함
            router.push(`/hashtags?tag=${encodeURIComponent(value)}`);
            setSearchValue("");
        }
    }

    // 메뉴 아이템 (중첩 배열 에러 수정한 단일 배열 구조)
    const menuItems = (user && user.nickname)
         ? [
                { key: "new", label: <Link href="/posts/new">✏️ NEW POST</Link> },
                { key: "profile", label: <Link href="/mypage">👤 MYPAGE </Link> },
                {
                    key: "logout",
                    label: (
                    <a onClick={handleLogout} style={{ cursor: "pointer" }}>
                    🔓 LOGOUT
                    </a>
                    ),
                },
            ]
         : [
                { key: "login", label: <Link href="/login">🔒Login</Link> },
                { key: "signup", label: <Link href="/signup">🆕👤Signup</Link> },
           ];

    /////////////////////////////// 
    // view
    return(<Layout>
        {/* Header*/}
        <Header style={{ padding: "0 24px", height: 64, display: "flex", alignItems: "center" }}>
            <Row align="middle" justify="space-between" style={{ width: "100%" }}> 
            {/* 로고 클릭 시 홈으로 이동 */}
            <Col flex="none">
                <Link href="/" passHref legacyBehavior>
                <a style={{ color: "#fff", fontWeight: "bold", fontSize: "18px", marginLeft: "12px", textDecoration: "none" }}>
                    THEJOA703
                </a>
                </Link>
            </Col> 
            {/* 메뉴 xs < 576, sm > 756, md > 786, lg >= 992 24칸 중에 몇칸 차지 */}
            <Col flex="auto" xs={0} sm={0} md={16} lg={18}>
                <Menu
                theme="dark"
                mode="horizontal"
                items={menuItems}
                overflowedIndicator={null}  
                />
            </Col>
            {/* 햄버거 버튼 */}
            <Col flex="none" >
                <Button
                type="text"
                icon={<MenuOutlined style={{ color: "white", fontSize: 20 }} />}
                onClick={() => setDrawerOpen(true)}
                />
            </Col>
            </Row>
        </Header>
        {/* 검색창(pc에서만 표시, 중앙정렬) */}
        {screens.md && (
        <div style={{ display: "flex", justifyContent: "center", alignItems: "center", padding: "16px", background: "#fafafa", borderBottom: "1px solid #eaeaea" }}>
          <Input
            prefix={<SearchOutlined style={{ color: "#999" }} />}
            placeholder="해시태그 검색"  
            value={searchValue}
            onChange={(e)=> setSearchValue(e.target.value)}
            onPressEnter={(e) => onSearch(e.target.value)}
            style={{
              maxWidth: 600,
              width: "100%",
              borderRadius: "20px",
              background: "#fff",
              padding: "6px 12px",
              verticalAlign: "middle"
            }}
          />
        </div>
        )}
        {/* Drawer(모바일 메뉴 + 검색창) */}
        <Drawer
            title="Menu"
            placement="right"
            onClose={() => setDrawerOpen(false)}
            open={drawerOpen}
        >   
            <Input.Search
                placeholder="해시태그 검색"
                enterButton="검색"
                value={searchValue}
                onChange={(e)=> setSearchValue(e.target.value)}
                onPressEnter={(value) =>{
                    setDrawerOpen(false);
                    onSearch(value);
                }}
                style={{marginBottom:16}}
            />
            <Menu
                mode="vertical"
                items={menuItems}
                onClick={() => setDrawerOpen(false)}
            />
        </Drawer>

        <Content style={{padding: "40px"}}>{children}</Content>
    </Layout>);
}

export default AppLayout;