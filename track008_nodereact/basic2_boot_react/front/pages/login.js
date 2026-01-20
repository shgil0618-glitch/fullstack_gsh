import React from "react";
import { useDispatch, useSelector } from "react-redux"; 
import { Row, Col, Form, Input, Button, Spin, message, Checkbox } from "antd"; 
import { useRouter } from "next/router"; 
import { loginSuccess, logout } from "../reducers/authReducer"; 
import api from "../api/axios";  

export default function LoginPage() {
    const dispatch = useDispatch();
    const router = useRouter(); // 수정: useSelector -> useRouter

    // Redux 상태 가져오기 (state 인자 추가)
    const { user, loading, error } = useSelector((state) => state.auth);

    // 로그인 버튼 클릭 시 실행
    const onFinish = async (values) => {
        try {
            // values에는 { email, password, remember }가 담겨 있습니다.
            const res = await api.post("/auth/login", 
                { ...values, provider: "local" },
                { headers: { "Content-Type": "application/json" } }
            );

            const { accessToken, user: userData } = res.data;

            if (userData && accessToken) {
                localStorage.setItem("accessToken", accessToken);
                dispatch(loginSuccess({ user: userData, accessToken }));
                message.success(`${userData.nickname}님 환영합니다!`);
                router.push("/mypage"); // 로그인 성공 후 이동할 경로
            } else {
                dispatch(logout());
                message.error("로그인 정보를 확인할 수 없습니다.");
            }
        } catch (err) {
            dispatch(logout());
            // 서버 에러 메시지가 있다면 출력, 없다면 기본 메시지
            const errorMsg = err.response?.data?.message || "로그인 실패: 이메일/비밀번호를 확인하세요.";
            message.error(errorMsg);
        }
    };

    // 소셜 로그인 핸들러
    const handleSocialLogin = (provider) => {
        window.location.href = `http://localhost:8484/oauth2/authorization/${provider}`;
    };

    return (
        <Row justify="center" style={{ marginTop: 80 }}>
            <Col xs={22} sm={16} md={10} lg={8}>
                <div style={{ textAlign: 'center', marginBottom: 40 }}>
                    <h2>로그인</h2>
                </div>

                {loading && (
                    <div style={{ textAlign: 'center', marginBottom: 20 }}>
                        <Spin size="large" tip="로그인 중..." />
                    </div>
                )}

                {/* 에러 메시지 표시 */}
                {error && <p style={{ color: "red", textAlign: "center" }}>{error}</p>}

                {/* 유저 정보가 없을 때만 폼 노출 */}
                {(!user || !user.nickname) ? (
                    <Form 
                        onFinish={onFinish} 
                        layout="vertical"
                        initialValues={{ remember: true }}
                    >
                        <Form.Item
                            label="이메일"
                            name="email" 
                            rules={[{ required: true, message: '이메일을 입력해주세요!' }]}
                        >
                            <Input placeholder="example@email.com" size="large" />
                        </Form.Item>

                        <Form.Item
                            label="비밀번호"
                            name="password"
                            rules={[{ required: true, message: '비밀번호를 입력해주세요!' }]}
                        >
                            <Input.Password size="large" />
                        </Form.Item>

                        <Form.Item name="remember" valuePropName="checked">
                            <Checkbox>로그인 상태 유지</Checkbox>
                        </Form.Item>

                        <Form.Item>
                            <Button type="primary" htmlType="submit" block size="large" loading={loading}>
                                로그인
                            </Button>
                        </Form.Item>

                        <div style={{ textAlign: 'center', marginTop: 20 }}>
                            <p>계정이 없으신가요? <Button type="link" onClick={() => router.push('/signup')}>회원가입</Button></p>
                        </div>

                        <hr style={{ margin: '24px 0', border: '0', borderTop: '1px solid #eee' }} />

                        {/* 소셜 로그인 섹션 */}
                        {/* <div style={{ display: 'flex', justifyContent: 'center', gap: '10px' }}>
                            <Button onClick={() => handleSocialLogin('google')} style={{ width: '100%' }}>Google 로그인</Button>
                            <Button onClick={() => handleSocialLogin('kakao')} style={{ width: '100%', backgroundColor: '#FEE500' }}>Kakao 로그인</Button>
                            <Button onClick={() => handleSocialLogin('naver')} style={{ width: '100%', backgroundColor: '#479612' }}>Naver 로그인</Button>
                        </div> */}
                        <div style={{ marginTop: 20, textAlign: "center" }}>
                          <img
                              src="/images/google.png"    
                              alt="Google Login"
                              style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }} 
                              onClick={() => handleSocialLogin('google')}
                           />
                        </div>
                        <div style={{ marginTop: 20, textAlign: "center" }}>
                          <img
                              src="/images/kakao.png"    
                              alt="kakao Login"
                              style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }} 
                              onClick={() => handleSocialLogin('kakao')}
                           />
                        </div>
                        <div style={{ marginTop: 20, textAlign: "center" }}>
                          <img
                              src="/images/naver.png"    
                              alt="naver Login"
                              style={{ cursor: "pointer", width: "200px", marginBottom: "10px" }} 
                              onClick={() => handleSocialLogin('naver')}
                           />
                        </div>
                    </Form>
                ) : (
                    <div style={{ textAlign: 'center' }}>
                        <p>{user.nickname}님은 이미 로그인 상태입니다.</p>
                        <Button onClick={() => router.push('/mypage')}>마이페이지로 이동</Button>
                    </div>
                )}
            </Col>
        </Row>
    );
}

// SSR 단순렌더 : 서버에서 데이터를 가져오거나 가공하지 않고, 그냥 페이지 컴포넌트를 서버에서 그려서 내려주는것.
export async function getServerSideProps() {
    return {props: {} };
}