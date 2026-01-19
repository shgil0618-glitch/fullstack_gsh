// react 불러오기
import React from 'react';
//redux wrapper 불러오기 (next.js 와 redux 연결)
//import { wrapper } from '../store/configureStore';
// 공용레이아웃 
//import AppLayout from '../components/AppLayout';
// Ant 디자인 
import 'antd/dist/antd.css';
// 글로벌 css
import '../styles/global.css';

function MyApp({ Component, pageProps }) {
  return (
    <AppLayout initialUser={pageProps.user}>
      <Component {...pageProps} />
    </AppLayout>
  );
}
// redux wrapper 적용
export default wrapper.withRedux(MyApp);
