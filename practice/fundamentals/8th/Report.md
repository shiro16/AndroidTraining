Practice Report for 2/8
------

実習のレポートを下記に記述してください

### Service

1. サンプルプロジェクト (ServiceSample) に、サービスのライフサイクルをログに出力する実装が格納されています。このプロジェクトをビルドし、ログがどのように表示されるかをレポートしてください。

start
 1.onCrete
 2.onStartCommand

stop
 1.onDestroy

bind
 1.onCreate
 2.onServiceConnected

unbind
 1.onUnbind
 2.onDestroy
 
Call IntentService
 1.onCreate
 2.onStartCommand
 3.onHandleIntent
 4.onDestroy

### Loader

1. サンプルプロジェクト (LoaderSample) に、AsyncTaskLoader のライフサイクルをログに出力する実装が格納されています。このプロジェクトをビルドし、ログがどのように出力されているかをレポートしてください。

 1.onCreateLoader
 2.onStartLoading
 3.loadInBackground
 4.deliverResult
 5.onLoadFinished
### AsyncTask

1. `AsyncTask#doInBackground()` で、TextView の文字を変更するような、UI の処理を実行するとどうなるかを、理由を添えてレポートしてください。
例外が発生