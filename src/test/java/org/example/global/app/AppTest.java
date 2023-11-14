package org.example.global.app;

import org.example.global.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    private static String run(String cmd) {
        Scanner scanner = TestUtil.genScanner(cmd.stripIndent().trim() + "\n종료");

        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        new App(scanner).run();

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        return out.trim();
    }

    @Test
    @DisplayName("프로그램 시작시 명언앱 출력")
    void test1() {
        String out = run("");

        assertThat(out).contains("== 명언 앱 ==");
    }


    @Test
    @DisplayName("종료 입력시 프로그램 종료")
    void test2() {
        String out = run("");
    }

    @Test
    @DisplayName("등록")
    void test3() {
        String out = run("""
                등록
                나는 신이다
                홍길동
                """);

        assertThat(out)
                .contains("명언 :")
                .contains("작가 :")
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("등록 번호 증가, 1개")
    void test4() {
        String out = run("""
                등록
                나는 신이다
                홍길동
                """);

        assertThat(out)
                .contains("1번 명언이 등록되었습니다.")
                .doesNotContain("2번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("등록 번호 증가, 2개")
    void test5() {
        String out2 = run("""
                등록
                나는 신이다
                홍길동
                등록
                나는 신이다
                홍길동
                """);

        assertThat(out2)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.")
                .doesNotContain("3번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록")
    void test6() {
        String out2 = run("""
                등록
                나는 신이다.
                홍길동
                등록
                나는 신이 아니다.
                홍길순
                목록
                """);

        assertThat(out2)
                .contains("번호 / 작가 / 명언")
                .contains("----------------------")
                .contains("2 / 홍길순 / 나는 신이 아니다.")
                .contains("1 / 홍길동 / 나는 신이다.");
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
