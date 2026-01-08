import Link from 'next/link';   // 대문자 L, 소문자 아님!

export default function Layout({ children }) {
  return (
    <div>
      {/* 헤더 */}
      <div className="p-5 bg-primary text-white text-center">
        <h1>공용 레이아웃 헤더</h1>
      </div>

      {/* 네비게이션 */}
      <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
        <div className="container-fluid">
          <ul className="navbar-nav">
            {/* 홈 링크 */}
            <li className="nav-item">
              <Link href="/users" className="nav-link active">
                <a class="nav-link" href="#">HOME</a>
              </Link>
            </li>
            {/* 로그인 */}
            <li className="nav-item">
              <Link href="/login" className="nav-link">
                <a class="nav-link" href="#">로그인</a>
              </Link>
            </li>
            {/* 회원가입 */}
            <li className="nav-item">
              <Link href="/join" className="nav-link">
                <a class="nav-link" href="#">회원가입</a>
              </Link>
            </li>
          </ul>
        </div>
      </nav>

      {/* 본문 */}
      <main className="container mt-4">{children}</main>

      {/* 푸터 */}
      <footer className="mt-5 p-4 bg-dark text-white text-center">
        <p>Footer</p>
      </footer>
    </div>
  );
}