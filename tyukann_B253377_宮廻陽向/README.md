# 素数判定アプリケーション (Prime Check Application)

このプロジェクトは、Javaによる様々なアルゴリズムを用いた素数判定プログラム集です。
授業課題としての基本的な判定プログラムに加え、劇的に高速な判定が可能なWeb UI付きのサーバープログラムが含まれています。

## 🚀 新機能: 超高速 Web UI 素数判定

`BigInteger` クラスの「ミラー・ラビン素数判定法」を用いた、非常に高速かつ巨大な桁数にも対応できる新しい素数判定プログラムです。
モダンなWebインターフェースで直感的に操作できます。

### 実行方法

1. **コンパイル**
   コマンドプロンプトまたはターミナルで、プロジェクトのルートディレクトリ（このファイルがある場所）にて以下のコマンドを実行します。
   ```bash
   javac -d bin -sourcepath src src/tyukann_B253377_宮廻陽向/FastPrimeServer.java
   ```

2. **実行**
   ```bash
   java -cp bin tyukann_B253377_宮廻陽向.FastPrimeServer
   ```

3. **ブラウザでアクセス**
   実行後、ブラウザを開いて以下のURLにアクセスしてください。
   [http://localhost:8000](http://localhost:8000)

   - 画面上の入力ボックスに判定したい整数を入力し、Enterキーまたはボタンを押すと結果が表示されます。
   - 非常に大きな桁数でも一瞬で判定可能です。

---

## 📂 既存のファイル構成

`src/tyukann_B253377_宮廻陽向/` ディレクトリ内:

- **PrimeCheckSimple.java**
  - 基本的な素数判定（全探索）。
  - `Scanner`による入力判定と、1〜1,000,000までのカウント計測。

- **PrimeCheckApplicaion.java**
  - 3つの判定手法の速度比較。
  - ① 偶数スキップ
  - ② `√n`まで計算
  - ③ 偶数スキップ ＋ `√n`まで計算

- **ouyou.java / ouyou_2.java**
  - 応用課題用コード。`PrimeCheckApplicaion`と同様のロジックを含みます。

## 🛠️ 必要要件

- Java Development Kit (JDK) 8以上
- モダンなWebブラウザ (Chrome, Edge, Firefox, Safariなど)
