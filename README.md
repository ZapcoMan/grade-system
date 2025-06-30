# 学生成绩管理系统

## 项目概述

本系统是一个基于 Spring Boot 和 Vue 的前后端分离的学生成绩管理系统。后端使用 Java 编写，前端使用 Vue 框架开发，数据库使用 MySQL。

该系统支持用户登录、成绩管理、通知发布、审计日志记录等功能。

---

## 项目结构

### 后端 (`springboot`)

#### 主要模块

- **`annotation`**：定义自定义注解（如 [AuditLogRecord](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\annotation\AuditLogRecord.java#L7-L12)）。
- **`aspect`**：切面编程相关代码（如 [AuditLogAspect](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\aspect\AuditLogAspect.java#L19-L48) 记录操作日志）。
- **`common`**：通用配置类，包括跨域配置、拦截器、返回结果封装等。
- **`controller`**：控制器类，处理 HTTP 请求，包含管理员、用户、文件上传等接口。
- **`entity`**：实体类，与数据库表映射。
- **`exception`**：异常处理类，统一处理系统异常。
- **`mapper`**：MyBatis 映射接口，用于数据库操作。
- **`service`**：业务逻辑接口及其实现类。
- **`utils`**：工具类，如 [TokenUtils](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\utils\TokenUtils.java#L18-L71) 处理 JWT 令牌。
- **`SpringbootApplication.java`**：Spring Boot 启动类。

#### 配置文件

- **`application.yml`**：Spring Boot 配置文件。
- **`pom.xml`**：Maven 依赖配置文件。

#### SQL 脚本

- **`sql/learnscore.sql`**：数据库初始化脚本。

---

### 前端 (`vue`)

#### 主要模块

- **`src/api`**：API 接口封装，如 `user.js` 定义用户相关的请求。
- **`src/assets/css`**：全局样式文件和 SCSS 变量。
- **`src/router/index.js`**：Vue 路由配置。
- **`src/utils/request.js`**：封装 Axios 请求。
- **`src/views/`**：页面组件，包括：
  - 登录页 (`Login.vue`)
  - 注册页 (`Register.vue`)
  - 主页 (`Home.vue`)
  - 用户管理 (`User.vue`)
  - 管理员管理 (`Admin.vue`)
  - 修改密码 (`UpdatePassword.vue`)
  - 个人信息 (`Person.vue`)
  - 管理界面 (`Manager.vue`)
  - 404 页面 (`404.vue`)
- **`App.vue`**：根组件。
- **`main.js`**：Vue 入口文件。
- **`index.html`**：HTML 模板。
- **`package.json`**：npm 包配置。
- **`vite.config.js`**：Vite 构建配置。

---

## 技术栈

### 后端

- **Java 17+**
- **Spring Boot 2.x**
- **MyBatis + MyBatis Plus**
- **JWT（JSON Web Token）**
- **MySQL**

### 前端

- **Vue 3**
- **Vite**
- **Axios**
- **Element Plus / Ant Design Vue（视具体实现而定）**

---

## 功能列表

| 功能模块 | 描述 |
|---------|------|
| 用户登录 | 使用 JWT 进行身份验证 |
| 成绩管理 | 支持查看、添加、修改、删除学生成绩 |
| 通知公告 | 管理员可以发布通知，用户可查看 |
| 日志记录 | 所有操作记录在审计日志中 |
| 文件上传 | 支持头像上传或批量导入成绩 |
| 权限控制 | 不同角色（如管理员、教师、学生）权限不同 |

---

## 数据库设计

数据库名称：`grade_system`

主要表：

- `user`：用户信息表
- `admin`：管理员信息表
- `account`：账号信息表
- `notification`：通知公告表
- `audit_log`：审计日志表

详细字段请参考 `sql/learnscore.sql`。

---

## 开发部署指南

### 后端部署

1. 安装 JDK 17+
2. 安装 Maven
3. 安装 MySQL
4. 导入 `sql/learnscore.sql` 到数据库
5. 修改 `application.yml` 中的数据库连接信息
6. 执行 `mvn spring-boot:run` 启动服务

### 前端部署

1. 安装 Node.js 18+
2. 进入 `vue` 目录
3. 执行 `npm install`
4. 执行 `npm run dev` 启动开发服务器

---
