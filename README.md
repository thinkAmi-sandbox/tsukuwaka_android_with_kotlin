# tsukuwaka_android_with_kotlin

「作ればわかる！Androidプログラミング Kotlin対応」(金宏 和實 著、翔泳社) を Jetpack Compose で実装してみた時のリポジトリです。  
[作ればわかる！Androidプログラミング Kotlin対応 10の実践サンプルで学ぶAndroidアプリ開発入門（金宏 和實）｜翔泳社の本](https://www.shoeisha.co.jp/book/detail/9784798160146)

なお、実装してみる一番の目的を「Jetpack Compose の書き方に慣れる」と置いたため、以下は今回やらないことと決めました。

- Jetpack Composeを使った時の良いディレクトリ構成
  - ディレクトリ構成を真剣に考えるよりも動くものを作る
    - 現時点ではどんな構成が一番良いのかよくわからないため
- MVVMを使うこと
  - 今回は画面が少ないこと、優先して学びたいことがあったため
- Kotlinっぽい書き方をすること
  - 今回はKotlinを学ぶのが目的ではないため、Android Studioでエラーやサジェストが出なければOKとした
- 書籍のアプリと同じデザイン・同じ実装とすること
  - どこまでJetpack Compose で作れるのか分かっていないため、おおよそできればOKとした
  - そのため、ConstraintLayout では作成していない
- 書籍のアプリをすべて実装すること
  - 自分専用のアプリを作るにあたり、必要そうなアプリのみ実装することにした
  - そのため、センサー系や地図系は実装していない
  - 実装したくなったらそのときに実装する

　  

# 関係するBlog (written in Japanese)

- [「作ればわかる！Androidプログラミング」をJetpack Composeで実装してみた - メモ的な思考的な](https://thinkami.hatenablog.com/entry/2022/08/31/213859)