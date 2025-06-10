# 如何使用GitHub构建APK的步骤

## 第一步：创建GitHub仓库

1. 登录您的GitHub账户
2. 点击右上角的"+"图标，选择"New repository"
3. 输入仓库名称，例如"auto-exit-app"
4. 选择仓库可见性（公开或私有）
5. 点击"Create repository"

## 第二步：上传代码到GitHub

使用命令行上传代码（如果您熟悉Git）：

```bash
# 初始化Git仓库
git init

# 添加所有文件到暂存区
git add .

# 提交更改
git commit -m "初始提交：自动退出应用"

# 添加远程仓库地址（替换为您的GitHub仓库URL）
git remote add origin https://github.com/您的用户名/auto-exit-app.git

# 推送代码到GitHub
git push -u origin master
```

或者，使用GitHub Desktop上传代码：

1. 下载并安装[GitHub Desktop](https://desktop.github.com/)
2. 登录您的GitHub账户
3. 点击"File" > "Add local repository"
4. 选择您的项目文件夹
5. 点击"Publish repository"
6. 输入仓库名称，选择可见性，然后点击"Publish repository"

## 第三步：等待GitHub Actions自动构建

1. 代码推送到GitHub后，GitHub Actions会自动开始构建过程
2. 点击仓库页面上的"Actions"标签查看构建进度
3. 等待构建完成

## 第四步：下载构建好的APK

1. 在Actions标签页中，点击最新的构建记录
2. 滚动到页面底部，在"Artifacts"部分找到"app-debug"或"app-release"
3. 点击下载，这就是构建好的APK文件

## 第五步：手动触发构建（如果需要）

如果您想手动触发构建过程：

1. 进入仓库的"Actions"标签页
2. 在左侧选择"构建Android APK"工作流
3. 点击"Run workflow"按钮
4. 在弹出的下拉菜单中，选择分支（通常是"master"或"main"）
5. 点击绿色的"Run workflow"按钮
6. 等待构建完成后，下载APK文件

## 第六步：创建GitHub Release发布版本

如果您想创建一个正式的发布版本，可以通过创建Git标签来触发Release构建：

### 使用命令行创建Release：

```bash
# 确保您的本地仓库是最新的
git pull origin master

# 创建一个带注释的标签（v开头，例如v1.0.0）
git tag -a v1.0.0 -m "第一个正式发布版本"

# 推送标签到GitHub
git push origin v1.0.0
```

### 使用GitHub网页界面创建Release：

1. 进入您的GitHub仓库页面
2. 点击"Releases"（在右侧边栏或代码标签下方）
3. 点击"Create a new release"或"Draft a new release"
4. 在"Tag version"字段中输入一个新标签（以"v"开头，例如v1.0.0）
5. 填写Release标题和描述
6. 点击"Publish release"

### 查看和下载Release：

1. 标签推送后，GitHub Actions会自动构建APK并创建Release
2. 进入仓库的"Releases"页面查看所有发布版本
3. 在发布页面可以直接下载APK文件
4. Release中会同时包含Debug和Release版本的APK

## 注意事项

- 首次构建可能需要几分钟时间，因为GitHub Actions需要设置构建环境
- 如果构建失败，请查看构建日志以获取错误信息
- 您可以随时修改代码并再次推送，GitHub Actions将自动触发新的构建
- Release版本的APK已经过签名，可以直接安装到Android设备上
- 确保每次创建Release时使用一个新的版本号（如v1.0.0, v1.0.1, v1.1.0等） 