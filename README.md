# 自动退出应用

这是一个简单的Android应用，在启动后会立即自动退出，不会保留任何后台进程。

## 功能特点

- 点击应用图标后，应用会立即启动并自动退出
- 不会在后台保留任何进程
- 显示简短的退出提示

## 使用GitHub Actions构建

此项目配置了GitHub Actions，可以自动构建APK文件。构建过程如下：

1. 将代码推送到GitHub仓库
2. GitHub Actions会自动触发构建流程
3. 构建完成后，可以在Actions标签页下载构建好的APK文件

### 手动触发构建
1. 进入GitHub仓库页面
2. 点击"Actions"标签
3. 在左侧选择"构建Android APK"
4. 点击"Run workflow"按钮
5. 等待构建完成后，点击构建记录
6. 在Artifacts部分下载"app-debug"或"app-release"文件，这就是构建好的APK

### 创建GitHub Release
当您想发布一个新版本时，可以创建一个带标签的Release：

1. 为您的更改创建一个新的Git标签（以"v"开头，例如v1.0.0）：
   ```bash
   git tag -a v1.0.0 -m "第一个发布版本"
   git push origin v1.0.0
   ```

2. 推送标签后，GitHub Actions会自动：
   - 构建Debug和Release版本的APK
   - 创建一个GitHub Release
   - 将APK文件附加到Release中

3. 您可以在GitHub仓库的"Releases"页面查看和下载发布的APK文件

## 本地构建方法

如果你想在本地构建，需要：

1. 安装Android Studio
2. 打开此项目
3. 点击"Build" > "Build Bundle(s) / APK(s)" > "Build APK(s)"
4. 构建完成后，APK文件将位于 `app/build/outputs/apk/debug/` 目录中

## 使用方法

1. 将APK文件安装到Android设备上
2. 点击应用图标
3. 应用将显示"正在退出应用..."的提示，然后立即退出

## 技术说明

应用使用了以下方法确保完全退出：

```java
// 结束当前活动
finish();

// 确保应用完全退出，不留后台进程
android.os.Process.killProcess(android.os.Process.myPid());
System.exit(0);
```

这确保了应用不会在后台保留任何进程。 