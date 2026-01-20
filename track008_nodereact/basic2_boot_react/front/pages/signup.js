import { Row, Col, Form, Input, Button, Upload, Spin, message, Result } from "antd"; 
import { PlusOutlined } from "@ant-design/icons";
import { useSelector, useDispatch } from "react-redux";
import axios from "../api/axios";
import { signupRequest, resetAuthState } from "../reducers/authReducer";
import { useRouter } from "next/router";
import { useEffect, useState, useCallback } from "react";

const normFile = (e) => {
    if (Array.isArray(e)) return e;
    return e?.fileList;
};

export default function Mypage() {
    const dispatch = useDispatch();
    const router = useRouter();

    // ★ 리듀서(authReducer.js)의 initialState 변수명과 정확히 일치시킴
    const { loading, error, success } = useSelector((state) => state.auth);
    const [fileList, setFileList] = useState([]);

    // 폼 제출 함수
    const onFinish = useCallback((values) => {
        const formData = new FormData();
        formData.append("email", values.email);
        formData.append("password", values.password);
        formData.append("nickname", values.nickname);
        formData.append("provider", "local");
        
        if (fileList.length > 0) {
            formData.append("ufile", fileList[0].originFileObj);
        }
        
        dispatch(signupRequest(formData));
    }, [fileList, dispatch]);

    const handleChange = ({ fileList: newFileList }) => setFileList(newFileList);

    // ★ 회원가입 성공 감시 및 페이지 이동
    useEffect(() => {
        if (success) {
            // 1. 성공 메시지 출력
            message.success("회원가입이 성공적으로 완료되었습니다.");
            
            // 2. 2초 후 로그인 페이지로 이동 (사용자가 성공 화면을 볼 시간을 줌)
            const timer = setTimeout(() => {
                router.push("/login").then(() => {
                    // 3. 이동 완료 후 리덕스 상태 초기화 (success를 다시 false로)
                    dispatch(resetAuthState());
                });
            }, 2000);

            return () => clearTimeout(timer);
        }
    }, [success, router, dispatch]);

    // 에러 발생 시 알림 처리
    useEffect(() => {
        if (error) {
            message.error(error);
        }
    }, [error]);

    return (
        <Row justify="center" style={{ marginTop: 40 }}>
            <Col xs={24} sm={16} md={8}>
                {/* 로딩 중일 때 전체화면 스피너 (선택 사항) */}
                {loading && (
                    <div style={{ textAlign: 'center', marginBottom: 20 }}>
                        <Spin size="large" tip="회원가입 처리 중..." />
                    </div>
                )}
                
                {/* success가 true면 성공 결과창을 보여주고, 아니면 폼을 보여줌 */}
                {success ? (
                    <Result
                        status="success"
                        title="가입 성공!"
                        subTitle="잠시 후 로그인 페이지로 자동 이동합니다."
                        extra={[
                            <Button type="primary" key="login" onClick={() => {
                                router.push("/login");
                                dispatch(resetAuthState());
                            }}>
                                바로 로그인하기
                            </Button>
                        ]}
                    />
                ) : (
                    <Form 
                        onFinish={onFinish} 
                        layout="vertical"
                        style={{ background: '#fff', padding: '24px', borderRadius: '8px', boxShadow: '0 2px 8px rgba(0,0,0,0.1)' }}
                    >
                        <h2 style={{ textAlign: 'center', marginBottom: 30 }}>회원가입</h2>

                        <Form.Item
                            label="이메일"
                            name="email"
                            rules={[
                                { required: true, message: '이메일을 입력하세요.' },
                                { type: 'email', message: '올바른 이메일 형식이 아닙니다.' },
                                {
                                    validator: async (_, value) => {
                                        if (!value || !value.includes('@')) return Promise.resolve();
                                        try {
                                            const res = await axios.get(`/auth/check-email?email=${encodeURIComponent(value)}`);
                                            if (res.data === true) return Promise.reject(new Error("이미 사용 중인 이메일입니다."));
                                            return Promise.resolve();
                                        } catch (err) {
                                            return Promise.resolve(); 
                                        }
                                    },
                                }
                            ]}
                        >
                            <Input placeholder="example@email.com" size="large" />
                        </Form.Item>

                        <Form.Item
                            label="비밀번호"
                            name="password"
                            rules={[{ required: true, message: '비밀번호를 입력하세요.' }]}
                        >
                            <Input.Password size="large" />
                        </Form.Item>

                        <Form.Item
                            label="닉네임"
                            name="nickname"
                            rules={[
                                { required: true, message: '닉네임을 입력하세요.' },
                                {
                                    validator: async (_, value) => {
                                        if (!value) return Promise.resolve();
                                        try {
                                            const res = await axios.get(`/auth/check-nickname?nickname=${encodeURIComponent(value)}`);
                                            if (res.data === true) return Promise.reject(new Error("이미 사용 중인 닉네임입니다."));
                                            return Promise.resolve();
                                        } catch (err) {
                                            return Promise.resolve();
                                        }
                                    },                                
                                }
                            ]}
                        >
                            <Input size="large" />
                        </Form.Item>

                        <Form.Item 
                            label="프로필 이미지" 
                            valuePropName="fileList" 
                            getValueFromEvent={normFile}
                        >
                            <Upload 
                                listType="picture-card"
                                fileList={fileList}
                                onChange={handleChange}
                                beforeUpload={() => false}
                                maxCount={1}
                            >
                                {fileList.length < 1 && (
                                    <button style={{ border: 0, background: 'none' }} type="button">
                                        <PlusOutlined />
                                        <div style={{ marginTop: 8 }}>Upload</div>
                                    </button>
                                )}
                            </Upload>
                        </Form.Item>

                        <Form.Item style={{ marginTop: 30 }}>
                            <Button type="primary" htmlType="submit" loading={loading} block size="large">
                                가입하기
                            </Button>
                        </Form.Item>
                    </Form>
                )}
            </Col>
        </Row>
    );
}