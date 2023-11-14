package org.example.global.app;

import org.example.global.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    @DisplayName("프로그램 시작시 명언앱 출력")
    void test1() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App().run();

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        assertThat(out).contains("== 명언 앱 ==");
    }


//    @Test
//    @DisplayName("종료를 입력하면 꺼진다.")
//    void test1() {
//        Scanner scanner = TestUtil.genScanner("""
//                종료
//                """.stripIndent());
//
//        new App(scanner).run();
//
//        scanner.close();
//
//    }
//
//    @Test
//    @DisplayName("등록을 입력하면 명언과 작가를 입력받는다.")
//    void test2() {
//        Scanner scanner = TestUtil.genScanner("""
//                등록
//                나는 천사다.
//                홍길동
//                종료
//                        """.stripIndent());
//
//        new App(scanner).run();
//
//        scanner.close();
//
//    }
//
//    @Test
//    @DisplayName("등록을 완료하면 1번 명언이 등록되었습니다.")
//    void test3() {
//        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
//
//        Scanner scanner = TestUtil.genScanner("""
//                등록
//                나는 천사다.
//                작자미상
//                홍길동
//                        """.stripIndent());
//
//        new App(scanner).run();
//
//        scanner.close();
//
//        String result = byteArrayOutputStream.toString();
//
//        assertThat(result).contains("1번 명언이 등록되었습니다.");
//
//        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
//
//    }
}
