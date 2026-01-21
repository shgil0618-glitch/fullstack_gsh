import cookie from "cookie";
import { message } from "antd";

import React, { useEffect, useState } from "react"; // REACT VIEW 상태
import { useDispatch, useSelector } from "react-redux"; // STORE(치킨집) 액션가져오기, REDUCER 전체상태
import {
  Card, Avatar, Spin, Descriptions, Form, Input, Button, Upload, List, Tabs,
} from "antd";
import { UploadOutlined } from "@ant-design/icons"; // 아이콘
import Link from "next/link";
import { useRouter } from "next/router";
 
import {
  updateNicknameRequest,
  updateProfileImageRequest,
  loginSuccess,
  logout,
} from "../reducers/authReducer";   // 액션

import api from "../api/axios";
import { wrapper } from "../store/configureStore";
import TabPane from "antd/lib/tabs/TabPane";

export default function Mypage(){
    // CODE
    const dispatch = useDispatch();
    const router = useRouter();
    const { user, loading } = useSelector((state) => state.auth); 

    useEffect(() => { 
        const verify = async () => {
            try {
                //1. LocalStorage에서 accessToken 가져오기
                const token = localStorage.getItem("accessToken");
                if (!token) {
                    dispatch(logout());
                    router.replace("/login");
                    return;
                }

                //2. 서버에서 현재요청의 쿠키를 그대로 전달해서 사용자 정보(me)를 조회
                const me = await api.get("/auth/me", {
                    headers: { Authorization: `Bearer ${token}` }, // CSR에서는 accessToken 헤더로 전달
                    withCredentials: true, // CORS 환경에서도 쿠키 포함 요청을 허용
                });

                //3. 응답에 사용자, 닉네임 존재하면 LOGIN 성공판단
                if (me?.data && me.data.nickname) { // 응답에 사용자, 닉네임 존재하면
                    dispatch(loginSuccess({ user: me.data })); // REDUX에서 로그인성공 액션
                } else {
                    dispatch(logout());
                    router.replace("/login");
                }
            } catch (error) {  // 에러시
                dispatch(logout());
                router.replace("/login");
            }
        };

        verify();
    }, [dispatch, router]);

    // 프로필 이미지 수정 시 올릴 파일
    const [fileList, setFileList] = useState([]);

    const imageUrl = user?.ufile  ? `${process.env.NEXT_PUBLIC_API_BASE_URL}/${user.ufile}` : undefined;

    if(loading){return <Spin/>;}
    if(!user || !user.nickname){return <p>로그인이 필요합니다.</p>;}

    // view
    return (
    <Card title="마이페이지" style={{ maxWidth: 800, margin: "20px auto" }}>
        <Tabs defaultActiveKey="profile">
            {/* 내 정보 탭 */}
            <TabPane>
                <div style={{display:"flex", alignItems:"center", marginBottom:"20px auto"}}>
                    <Avatar src={imageUrl} size={64}>
                        {user.nickname?.[0]}
                    </Avatar>
                    <Descriptions bordered column={1} size="midle" style={{marginLeft: 20}}>
                        <Descriptions.Item label="이메일">{user.email}</Descriptions.Item>
                        <Descriptions.Item label="닉네임">{user.nickname}</Descriptions.Item>
                        <Descriptions.Item label="권한">{user.role}</Descriptions.Item>
                    </Descriptions>
                </div>
                {/* 닉네임 수정 */}
                <Form 
                    onFinish={(value)=>{ 
                        dispatch(updateNicknameRequest({ userId : user.id , nickname: value.nickname}))  }
                    }
                    layout="inline"
                    style={{ marginBottom: 20 }}
                >
                    <Form.Item
                    name="nickname"
                    rules={[{ required: true, message: "새 닉네임을 입력하세요" }]}
                    >
                    <Input placeholder="새 닉네임" />
                    </Form.Item>
                    <Button type="primary" htmlType="submit">닉네임 변경</Button>
                </Form>
                {/* 프로필 이미지 수정 */}
                <Form layout="inline" style={{ marginBottom: 20 }}>
                    <Form.Item>
                    <Upload
                        beforeUpload={() => false}
                        fileList={fileList}
                        onChange={({ fileList }) => setFileList(fileList)}
                        maxCount={1}
                    >
                        <Button icon={<UploadOutlined />}>이미지 선택</Button>
                    </Upload>
                    </Form.Item>
                    <Button
                    type="primary"
                    onClick={()=>{
                        if(!user || fileList.length === 0) return;
                        const file = fileList[0]?.originFileObj;
                        dispatch(updateProfileImageRequest({userId: user.id, file}));
                    }} 
                    >
                    프로필 이미지 변경
                    </Button>
                </Form> 
            </TabPane>
            {/* 팔로워 탭 */}
            <TabPane>
                
            </TabPane>
            {/* 팔로잉 탭 */}
            <TabPane>
                
            </TabPane>
            {/* 내 정보 탭 */}
            <TabPane>
                
            </TabPane>
        </Tabs>
    </Card>
    );

}

// getServerSidProps - wrapper로 감싸서 서버사이드에서 스토어에 접근할수 있도록 함.
export const getServerSideProps = wrapper.getServerSideProps((store) => async (ctx) => {
  try {
    // 서버에서 현재요청의 쿠키를 그대로 전달해서 사용자 정보(me)를 조회
    const me = await api.get("/auth/me", {
      headers: { cookie: ctx.req.headers.cookie || "" }, // SSR에서는 브라우저가 아님 직접 쿠키로 헤더로 전달
      withCredentials: true, // CORS 환경에서도 쿠키 포함 요청을 허용
    });

    if (me?.data && me.data.nickname) { // 응답에 사용자, 닉네임 존재하면
      store.dispatch(loginSuccess({ user: me.data })); // REDUX에서 로그인성공 액션
      return { props: {} };
    }
  } catch (error) {  // 에러시
    return {
      redirect: {
        destination: "/login", // 로그인페이지
        permanent: false, // 302(임시) 리다이렉트 처리 -캐싱
      },
    };
  }
 
  return { props: {} };
});
