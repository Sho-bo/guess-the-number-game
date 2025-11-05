import java.util.*;

class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----- 数字当てゲーム開始 -----\n");

        int minValue = inputValue(sc, "最小値(整数)を入力してください：");
        int maxValue = inputMaxValue(sc, minValue);

        int ans = generateAnswer(minValue, maxValue);

        gameStart(sc, minValue, maxValue, ans);

        sc.close();
    }

    private static int inputValue(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (!sc.hasNextLine()) {
                System.out.println("\n入力が終了しました。ゲームを終了します。");
                System.exit(0);
            }

            String input = sc.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("⚠️  整数以外が入力されました。\n");
            }
        }
    }

    private static int inputMaxValue(Scanner sc, int minValue) {
        while (true) {
            int maxValue = inputValue(sc, "最大値(整数)を入力してください：");

            if (minValue >= maxValue) {
                System.out.println("⚠️  最大値は最小値を超える値を入力してください。\n");
            } else {
                return maxValue;
            }
        }
    }

    private static int generateAnswer(int minValue, int maxValue) {
        Random random = new Random();

        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    private static void gameStart(Scanner sc, int minValue, int maxValue, int ans) {
        System.out.println("\n----- " + minValue + "〜" + maxValue + "の中でランダムな数値が1つ選ばれました。当てましょう。 -----\n");

        while (true) {
            int playerInput = inputValue(sc, "整数を入力してください：");

            if (ans == playerInput) {
                System.out.println("正解！");
                return;
            } else {
                System.out.println("はずれ！");
            }
        }
    }
}