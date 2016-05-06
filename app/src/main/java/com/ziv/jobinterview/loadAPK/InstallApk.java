package com.ziv.jobinterview.loadapk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * 安装apk文件
 * 系统安装文件源码路径/framework/base/cmds/pm/src/com/android/commands/pm/Pm.java
 * 参考链接：http://www.jb51.net/article/78463.htm
 * Created by Ziv on 2016/5/6.
 */
public class InstallApk {
    public void started(Context context, File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

}
/**
 * Permission依据风险分为以下四个级别
 * normal
 * dangerous
 * signature
 * signatureOrSystem
 * <p>
 * 系统5.0源码中实现安装的方法
 * private void runInstall() {
 * int installFlags = 0;
 * int userId = UserHandle.USER_ALL;
 * String installerPackageName = null;
 * <p>
 * String opt;
 * <p>
 * String originatingUriString = null;
 * String referrer = null;
 * String abi = null;
 * <p>
 * while ((opt=nextOption()) != null) {
 * if (opt.equals("-l")) {
 * installFlags |= PackageManager.INSTALL_FORWARD_LOCK;
 * } else if (opt.equals("-r")) {
 * installFlags |= PackageManager.INSTALL_REPLACE_EXISTING;
 * } else if (opt.equals("-i")) {
 * installerPackageName = nextOptionData();
 * if (installerPackageName == null) {
 * System.err.println("Error: no value specified for -i");
 * return;
 * }
 * } else if (opt.equals("-t")) {
 * installFlags |= PackageManager.INSTALL_ALLOW_TEST;
 * } else if (opt.equals("-s")) {
 * // Override if -s option is specified.
 * installFlags |= PackageManager.INSTALL_EXTERNAL;
 * } else if (opt.equals("-f")) {
 * // Override if -s option is specified.
 * installFlags |= PackageManager.INSTALL_INTERNAL;
 * } else if (opt.equals("-d")) {
 * installFlags |= PackageManager.INSTALL_ALLOW_DOWNGRADE;
 * } else if (opt.equals("--originating-uri")) {
 * originatingUriString = nextOptionData();
 * if (originatingUriString == null) {
 * System.err.println("Error: must supply argument for --originating-uri");
 * return;
 * }
 * } else if (opt.equals("--referrer")) {
 * referrer = nextOptionData();
 * if (referrer == null) {
 * System.err.println("Error: must supply argument for --referrer");
 * return;
 * }
 * } else if (opt.equals("--abi")) {
 * abi = checkAbiArgument(nextOptionData());
 * } else if (opt.equals("--user")) {
 * userId = Integer.parseInt(nextOptionData());
 * } else {
 * System.err.println("Error: Unknown option: " + opt);
 * return;
 * }
 * }
 * <p>
 * if (userId == UserHandle.USER_ALL) {
 * userId = UserHandle.USER_OWNER;
 * installFlags |= PackageManager.INSTALL_ALL_USERS;
 * }
 * <p>
 * final Uri verificationURI;
 * final Uri originatingURI;
 * final Uri referrerURI;
 * <p>
 * if (originatingUriString != null) {
 * originatingURI = Uri.parse(originatingUriString);
 * } else {
 * originatingURI = null;
 * }
 * <p>
 * if (referrer != null) {
 * referrerURI = Uri.parse(referrer);
 * } else {
 * referrerURI = null;
 * }
 * <p>
 * // Populate apkURI, must be present
 * final String apkFilePath = nextArg();
 * System.err.println("\tpkg: " + apkFilePath);
 * if (apkFilePath == null) {
 * System.err.println("Error: no package specified");
 * return;
 * }
 * <p>
 * // Populate verificationURI, optionally present
 * final String verificationFilePath = nextArg();
 * if (verificationFilePath != null) {
 * System.err.println("\tver: " + verificationFilePath);
 * verificationURI = Uri.fromFile(new File(verificationFilePath));
 * } else {
 * verificationURI = null;
 * }
 * <p>
 * LocalPackageInstallObserver obs = new LocalPackageInstallObserver();
 * try {
 * VerificationParams verificationParams = new VerificationParams(verificationURI,
 * originatingURI, referrerURI, VerificationParams.NO_UID, null);
 * <p>
 * mPm.installPackageAsUser(apkFilePath, obs.getBinder(), installFlags,
 * installerPackageName, verificationParams, abi, userId); //注意！！最终就是调用这个方法来进行安装的
 * <p>
 * synchronized (obs) {
 * while (!obs.finished) {
 * try {
 * obs.wait();
 * } catch (InterruptedException e) {
 * }
 * }
 * if (obs.result == PackageManager.INSTALL_SUCCEEDED) {
 * System.out.println("Success");
 * } else {
 * System.err.println("Failure ["
 * + installFailureToString(obs)
 * + "]");
 * }
 * }
 * } catch (RemoteException e) {
 * System.err.println(e.toString());
 * System.err.println(PM_NOT_RUNNING_ERR);
 * }
 * }
 */