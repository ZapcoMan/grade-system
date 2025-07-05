`markdown
# 学生成绩管理系统

## 项目概述

本系统是一个基于 **Spring Boot + Vue** 构建的前后端分离的学生成绩管理系统。后端使用 **Java 17+** 编写，采用 **Spring Boot** 框架；前端使用 **Vue 3 + Vite** 开发，UI 支持响应式布局；数据库使用 **MySQL**。

系统实现了完整的用户管理、成绩管理、通知公告、操作日志记录等功能，并引入了以下增强特性：

- JWT 鉴权机制
- 审计日志记录（通过注解与切面实现）
- 文件上传支持（头像、Excel 成绩导入等）
- 多角色权限控制（管理员、教师、学生）

---

## 目录

- [项目概述](#项目概述)
- [项目结构](#项目结构)
    - [后端 (`springboot`)](#后端-springboot)
    - [前端 (`vue`)](#前端-vue)
- [技术栈](#技术栈)
- [功能列表](#功能列表)
- [数据库设计](#数据库设计)
- [开发部署指南](#开发部署指南)
## 项目结构

### 后端 (`springboot`)

#### 主要模块

| 包名                                                                                                                                            | 功能描述                                                                                                                                                                                                                                                                                              |
|-----------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `annotation`                                                                                                                                  | 自定义注解，如 [[@AuditLogRecord](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\annotation\AuditLogRecord.java#L15-L20)](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\annotation\AuditLogRecord.java) 用于标记需要记录日志的方法 |
| `aspect`                                                                                                                                      | 切面类，如 [[AuditLogAspect](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\aspect\AuditLogAspect.java#L25-L74)](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\aspect\AuditLogAspect.java) 实现操作日志记录逻辑               |
| `common`                                                                                                                                      | 通用配置类，包括跨域配置、拦截器、统一返回封装等                                                                                                                                                                                                                                                                          |
| `config`                                                                                                                                      | 系统配置类，如安全配置、Redis 配置、Jackson 序列化配置等                                                                                                                                                                                                                                                               |
| `controller`                                                                                                                                  | 控制器类，处理 HTTP 请求，包含管理员、用户、文件上传等接口                                                                                                                                                                                                                                                                  |
| `dto`                                                                                                                                         | 数据传输对象，用于接收请求参数                                                                                                                                                                                                                                                                                   |
| `entity`                                                                                                                                      | 实体类，与数据库表一一映射                                                                                                                                                                                                                                                                                     |
| `enums`                                                                                                                                       | 枚举类，如角色枚举、结果状态码等                                                                                                                                                                                                                                                                                  |
| `exception`                                                                                                                                   | 异常处理类，统一处理系统异常                                                                                                                                                                                                                                                                                    |
| [mapper](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\service\impl\CourseServiceImpl.java#L13-L14) | MyBatis 映射接口，用于数据库操作                                                                                                                                                                                                                                                                              |
| `security`                                                                                                                                    | 安全相关类，如 JWT 过滤器、鉴权逻辑                                                                                                                                                                                                                                                                              |
| `service`                                                                                                                                     | 业务逻辑接口及其实现类                                                                                                                                                                                                                                                                                       |
| `strategy`                                                                                                                                    | 策略模式实现的扩展逻辑                                                                                                                                                                                                                                                                                       |
| `utils`                                                                                                                                       | 工具类，如 [[TokenUtils](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\utils\TokenUtils.java#L21-L80)](file://C:\Users\Administrator\Desktop\grade-system\springboot\src\main\java\com\example\utils\TokenUtils.java) 处理 JWT 令牌                              |
| `SpringbootApplication.java`                                                                                                                  | Spring Boot 启动类                                                                                                                                                                                                                                                                                   |

#### 配置文件

- `application.yml`：Spring Boot 主配置文件
- `pom.xml`：Maven 依赖配置文件

#### SQL 脚本

- `sql/learnscore.sql`：数据库初始化脚本

---

### 前端 (`vue`)

#### 主要模块

| 目录                     | 功能描述                           |
|------------------------|--------------------------------|
| `src/api`              | API 接口封装，如 `user.js` 定义用户相关的请求 |
| `src/assets/css`       | 全局样式文件和 SCSS 变量                |
| `src/router/index.js`  | Vue 路由配置                       |
| `src/utils/request.js` | 封装 Axios 请求                    |
| `src/views/`           | 页面组件目录，包括：                     |

- `Login.vue` 登录页  
  - `Register.vue` 注册页  
  - `Home.vue` 主页  
  - `User.vue` 用户管理  
  - `Admin.vue` 管理员管理  
  - `UpdatePassword.vue` 修改密码  
  - `Person.vue` 个人信息  
  - `Manager.vue` 管理界面  
  - `404.vue` 错误页面 |
| `App.vue`           | 根组件 |
| `main.js`           | Vue 入口文件 |
| `index.html`        | HTML 模板 |
| `package.json`      | npm 包配置 |
| `vite.config.js`    | Vite 构建配置 |

---

## 技术栈

### 后端

- **Java 17+**
- **Spring Boot 2.x**
- **MyBatis / MyBatis Plus**
- **JWT（JSON Web Token）**
- **MySQL**
- **Redis**
- **Lombok**

### 前端

- **Vue 3**
- **Vite**
- **Axios**
- **Element Plus**（UI 框架）
- **SCSS / CSS Modules**

---

## 功能列表

| 功能模块 | 描述                     |
|------|------------------------|
| 用户登录 | 使用 JWT 进行身份验证，支持多角色登录  |
| 成绩管理 | 支持查看、添加、修改、删除学生成绩      |
| 通知公告 | 管理员可以发布通知，用户可查看        |
| 日志记录 | 所有操作记录在审计日志中，可通过注解灵活控制 |
| 文件上传 | 支持头像上传、批量 Excel 导入成绩   |
| 权限控制 | 不同角色（如管理员、教师、学生）拥有不同权限 |

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
