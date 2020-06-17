# API测试文档


<a name="overview"></a>
## 概览
权限管理主系统测试文档


### 版本信息
*版本* : v1.0


### 联系方式
*名字* : 权限系统主页  
*邮箱* : test@qq.com


### 许可信息
*许可证* : Apache2.0  
*许可网址* : http://www.apache.org/licenses/LICENSE-2.0  
*服务条款* : null


### URI scheme
*域名* : localhost:8443  
*基础路径* : /


### 标签

* basic-error-controller : Basic Error Controller
* operation-handler : Operation Handler
* web-mvc-endpoint-handler-mapping : Web Mvc Endpoint Handler Mapping
* 字典管理接口 : Sys Dict Controller
* 文件上传接口 : File Upload
* 权限管理接口 : Sys Role Controller
* 用户管理接口 : Sys User Controller
* 登录接口 : Sys Login Controller
* 登录日志接口 : Sys Login Log Controller
* 系统日志接口 : Sys Log Controller
* 系统配置接口 : Sys Config Controller
* 菜单管理接口 : Sys Menu Controller
* 部门接口 : Sys Dept Controller




<a name="paths"></a>
## 资源

<a name="basic-error-controller_resource"></a>
### Basic-error-controller
Basic Error Controller


<a name="errorusingpost"></a>
#### error
```
POST /error
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< string, object > map|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/error
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="errorusingget"></a>
#### error
```
GET /error
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< string, object > map|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/error
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="errorusingput"></a>
#### error
```
PUT /error
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< string, object > map|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/error
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="errorusingdelete"></a>
#### error
```
DELETE /error
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< string, object > map|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/error
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="errorusingpatch"></a>
#### error
```
PATCH /error
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< string, object > map|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/error
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="errorusinghead"></a>
#### error
```
HEAD /error
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< string, object > map|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/error
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="errorusingoptions"></a>
#### error
```
OPTIONS /error
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< string, object > map|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/error
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="operation-handler_resource"></a>
### Operation-handler
Operation Handler


<a name="handleusingget"></a>
#### handle
```
GET /actuator/auditevents
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/auditevents
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_1"></a>
#### handle
```
GET /actuator/beans
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/beans
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_2"></a>
#### handle
```
GET /actuator/conditions
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/conditions
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_3"></a>
#### handle
```
GET /actuator/configprops
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/configprops
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_4"></a>
#### handle
```
GET /actuator/health
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/health
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_5"></a>
#### handle
```
GET /actuator/heapdump
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/octet-stream`


##### HTTP请求示例

###### 请求 path
```
/actuator/heapdump
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_6"></a>
#### handle
```
GET /actuator/httptrace
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/httptrace
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_7"></a>
#### handle
```
GET /actuator/info
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/info
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_9"></a>
#### handle
```
GET /actuator/loggers
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/loggers
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingpost"></a>
#### handle
```
POST /actuator/loggers/{name}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/actuator/loggers/{name}
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_8"></a>
#### handle
```
GET /actuator/loggers/{name}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/loggers/{name}
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_10"></a>
#### handle
```
GET /actuator/mappings
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/mappings
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_11"></a>
#### handle
```
GET /actuator/scheduledtasks
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/scheduledtasks
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingpost_1"></a>
#### handle
```
POST /actuator/shutdown
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/shutdown
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="handleusingget_12"></a>
#### handle
```
GET /actuator/threaddump
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**body**  <br>*可选*|body|< string, string > map|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator/threaddump
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="web-mvc-endpoint-handler-mapping_resource"></a>
### Web-mvc-endpoint-handler-mapping
Web Mvc Endpoint Handler Mapping


<a name="linksusingget"></a>
#### links
```
GET /actuator
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< string, < string, [Link](#link) > map > map|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json`
* `application/vnd.spring-boot.actuator.v2+json`


##### HTTP请求示例

###### 请求 path
```
/actuator
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
"object"
```


<a name="c2d591d014a87f67228e01312feeef91"></a>
### 字典管理接口
Sys Dict Controller


<a name="deleteusingpost_2"></a>
#### 删除字典记录
```
POST /sys_dict/delete
```


##### 说明
删除字典记录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**records**  <br>*必填*|records|< [SysDict](#sysdict) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_dict/delete
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
[ {
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "description" : "string",
  "id" : "string",
  "label" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "remarks" : "string",
  "sort" : 0,
  "type" : "string",
  "value" : "string"
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpageusingpost_1"></a>
#### 分页查询字典记录
```
POST /sys_dict/findByPage
```


##### 说明
分页查询字典记录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**myPageRequest**  <br>*必填*|myPageRequest|[MyPageRequest](#mypagerequest)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_dict/findByPage
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "pageNum" : 0,
  "pageSize" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="saveusingpost_2"></a>
#### 保存字典管理
```
POST /sys_dict/save
```


##### 说明
保存字典管理


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**record**  <br>*必填*|record|[SysDict](#sysdict)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_dict/save
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "description" : "string",
  "id" : "string",
  "label" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "remarks" : "string",
  "sort" : 0,
  "type" : "string",
  "value" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="95894f3bf3d2ce1a4719ee711842175a"></a>
### 文件上传接口
File Upload


<a name="uploadsomefilesusingpost"></a>
#### 单个文件上传
```
POST /test/uploadFiles
```


##### 说明
单个文件上传


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**FormData**|**uploadFiles**  <br>*可选*|uploadFiles|< file > array(multi)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/test/uploadFiles
```


###### 请求 header
```
json :
"string"
```


###### 请求 formData
```
json :
"file"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="uploadonefileusingpost"></a>
#### 单个文件上传
```
POST /test/uploadOneFile
```


##### 说明
单个文件上传


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**FormData**|**uploadFile**  <br>*可选*|uploadFile|file|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `multipart/form-data`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/test/uploadOneFile
```


###### 请求 header
```
json :
"string"
```


###### 请求 formData
```
json :
"file"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="0d2db55e9c7add86d2a8bd51545a2bdd"></a>
### 权限管理接口
Sys Role Controller


<a name="deleteusingpost_6"></a>
#### 删除权限
```
POST /sys_role/delete
```


##### 说明
删除权限


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**records**  <br>*必填*|records|< [SysRole](#sysrole) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_role/delete
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
[ {
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "id" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "name" : "string",
  "remark" : "string"
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findallusingget"></a>
#### 查询所有权限
```
GET /sys_role/findAll
```


##### 说明
查询所有权限


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_role/findAll
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpageusingpost_4"></a>
#### 分页查询权限
```
POST /sys_role/findByPage
```


##### 说明
分页查询权限


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**myPageRequest**  <br>*必填*|myPageRequest|[MyPageRequest](#mypagerequest)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_role/findByPage
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "pageNum" : 0,
  "pageSize" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findrolemenususingget"></a>
#### 根据权限id查询菜单
```
GET /sys_role/findRoleMenus
```


##### 说明
根据权限id查询菜单


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Query**|**roleId**  <br>*必填*|roleId|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_role/findRoleMenus
```


###### 请求 header
```
json :
"string"
```


###### 请求 query
```
json :
{
  "roleId" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="saveusingpost_4"></a>
#### 保存权限
```
POST /sys_role/save
```


##### 说明
保存权限


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**record**  <br>*必填*|record|[SysRole](#sysrole)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_role/save
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "id" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "name" : "string",
  "remark" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="saverolemenususingpost"></a>
#### 根据权限修改菜单权限
```
POST /sys_role/saveRoleMenus
```


##### 说明
根据权限修改菜单权限


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**records**  <br>*必填*|records|< [SysRoleMenu](#sysrolemenu) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_role/saveRoleMenus
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
[ {
  "createBy" : "string",
  "createTime" : "string",
  "id" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "menuId" : "string",
  "roleId" : "string"
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="459ddcdf2261352d74a9df803f455247"></a>
### 用户管理接口
Sys User Controller


<a name="deleteusingpost_7"></a>
#### 删除用户
```
POST /sys_user/delete
```


##### 说明
批量删除用户


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**records**  <br>*必填*|records|< [SysUser](#sysuser) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_user/delete
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
[ {
  "avatar" : "string",
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "deptId" : "string",
  "deptName" : "string",
  "email" : "string",
  "id" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "mobile" : "string",
  "name" : "string",
  "nickName" : "string",
  "password" : "string",
  "roleNames" : "string",
  "salt" : "string",
  "status" : 0,
  "userRoles" : [ {
    "createBy" : "string",
    "createTime" : "string",
    "id" : "string",
    "lastUpdateBy" : "string",
    "lastUpdateTime" : "string",
    "roleId" : "string",
    "userId" : "string"
  } ]
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findbyusernameusingget"></a>
#### 根据姓名查询用户
```
GET /sys_user/findByName
```


##### 说明
根据姓名查询用户


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Query**|**name**  <br>*必填*|name|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_user/findByName
```


###### 请求 header
```
json :
"string"
```


###### 请求 query
```
json :
{
  "name" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpageusingpost_5"></a>
#### 分页查询用户
```
POST /sys_user/findByPage
```


##### 说明
分页查询用户


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**myPageRequest**  <br>*必填*|myPageRequest|[MyPageRequest](#mypagerequest)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_user/findByPage
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "pageNum" : 0,
  "pageSize" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpermissionsusingget"></a>
#### 根据姓名查询用户权限
```
GET /sys_user/findPermissions
```


##### 说明
根据姓名查询用户权限


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Query**|**name**  <br>*必填*|name|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_user/findPermissions
```


###### 请求 header
```
json :
"string"
```


###### 请求 query
```
json :
{
  "name" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="saveusingpost_5"></a>
#### 保存用户
```
POST /sys_user/save
```


##### 说明
保存用户


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**record**  <br>*必填*|record|[SysUser](#sysuser)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_user/save
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "avatar" : "string",
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "deptId" : "string",
  "deptName" : "string",
  "email" : "string",
  "id" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "mobile" : "string",
  "name" : "string",
  "nickName" : "string",
  "password" : "string",
  "roleNames" : "string",
  "salt" : "string",
  "status" : 0,
  "userRoles" : [ {
    "createBy" : "string",
    "createTime" : "string",
    "id" : "string",
    "lastUpdateBy" : "string",
    "lastUpdateTime" : "string",
    "roleId" : "string",
    "userId" : "string"
  } ]
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="0c1d08e524d130018a6e203826c0ddaf"></a>
### 登录接口
Sys Login Controller


<a name="captchausingget"></a>
#### 生成验证码
```
GET /captcha.jpg
```


##### 说明
生成验证码


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/captcha.jpg
```


###### 请求 header
```
json :
"string"
```


<a name="loginusingpost"></a>
#### 登录接口
```
POST /login
```


##### 说明
登录接口，携带token令牌信息


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**loginBean**  <br>*必填*|loginBean|[LoginBean](#loginbean)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/login
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "account" : "string",
  "captcha" : "string",
  "password" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="28eae16dd4a7e641846407470404babf"></a>
### 登录日志接口
Sys Login Log Controller


<a name="deleteusingpost_4"></a>
#### 删除登录日志
```
POST /sys_login_log/delete
```


##### 说明
删除登录日志


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**records**  <br>*必填*|records|< [SysLoginLog](#sysloginlog) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_login_log/delete
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
[ {
  "createTime" : "string",
  "id" : "string",
  "ip" : "string",
  "remark" : "string",
  "status" : "string",
  "userName" : "string"
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpageusingpost_3"></a>
#### 分页查询登录日志
```
POST /sys_login_log/findByPage
```


##### 说明
分页查询登录日志


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**myPageRequest**  <br>*必填*|myPageRequest|[MyPageRequest](#mypagerequest)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_login_log/findByPage
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "pageNum" : 0,
  "pageSize" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="d2af8a551e9e8b43fbe446ec6b67b0b3"></a>
### 系统日志接口
Sys Log Controller


<a name="deleteusingpost_3"></a>
#### 删除日志记录
```
POST /sys_log/delete
```


##### 说明
删除日志记录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**records**  <br>*必填*|records|< [SysLog](#syslog) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_log/delete
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
[ {
  "createBy" : "string",
  "createTime" : "string",
  "id" : "string",
  "ip" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "method" : "string",
  "operation" : "string",
  "params" : "string",
  "time" : 0,
  "userName" : "string"
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpageusingpost_2"></a>
#### 分页查询日志记录
```
POST /sys_log/findByPage
```


##### 说明
分页查询日志记录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**myPageRequest**  <br>*必填*|myPageRequest|[MyPageRequest](#mypagerequest)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_log/findByPage
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "pageNum" : 0,
  "pageSize" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="63784d53a9ff40d8e16ba5f80c2897ab"></a>
### 系统配置接口
Sys Config Controller


<a name="deleteusingpost"></a>
#### 删除系统配置
```
POST /sys_config/delete
```


##### 说明
批量删除


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Path**|**records**  <br>*必填*|系统配置记录集合|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_config/delete
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpageusingpost"></a>
#### 分页查询系统配置记录
```
POST /sys_config/findByPage
```


##### 说明
根据分页参数分页查询系统配置记录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**myPageRequest**  <br>*必填*|myPageRequest|[MyPageRequest](#mypagerequest)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_config/findByPage
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "pageNum" : 0,
  "pageSize" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="saveusingpost"></a>
#### 保存系统配置
```
POST /sys_config/save
```


##### 说明
系统配置记录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Path**|**record**  <br>*必填*|系统配置记录|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_config/save
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="e94d13a39039ece70666c46db3da1f9f"></a>
### 菜单管理接口
Sys Menu Controller


<a name="deleteusingpost_5"></a>
#### 删除菜单记录
```
POST /sys_menu/delete
```


##### 说明
删除菜单记录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**records**  <br>*必填*|records|< [SysMenu](#sysmenu) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_menu/delete
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
[ {
  "children" : [ {
    "children" : [ "..." ],
    "createBy" : "string",
    "createTime" : "string",
    "delFlag" : 0,
    "icon" : "string",
    "id" : "string",
    "lastUpdateBy" : "string",
    "lastUpdateTime" : "string",
    "level" : 0,
    "name" : "string",
    "orderNum" : 0,
    "parentId" : "string",
    "parentName" : "string",
    "perms" : "string",
    "type" : 0,
    "url" : "string"
  } ],
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "icon" : "string",
  "id" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "level" : 0,
  "name" : "string",
  "orderNum" : 0,
  "parentId" : "string",
  "parentName" : "string",
  "perms" : "string",
  "type" : 0,
  "url" : "string"
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="deleteusingget"></a>
#### 查询菜单树形数据，用于修改权限
```
GET /sys_menu/findMenuTree
```


##### 说明
查询菜单树形数据，用于修改权限


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_menu/findMenuTree
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findnavtreeusingget"></a>
#### 查询菜单树形数据，用于系统左侧导航
```
GET /sys_menu/findNavTree
```


##### 说明
查询菜单树形数据，用于系统左侧导航


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Query**|**userName**  <br>*必填*|userName|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_menu/findNavTree
```


###### 请求 header
```
json :
"string"
```


###### 请求 query
```
json :
{
  "userName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="saveusingpost_3"></a>
#### 保存菜单记录
```
POST /sys_menu/save
```


##### 说明
保存菜单记录


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**record**  <br>*必填*|record|[SysMenu](#sysmenu)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_menu/save
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "children" : [ {
    "children" : [ "..." ],
    "createBy" : "string",
    "createTime" : "string",
    "delFlag" : 0,
    "icon" : "string",
    "id" : "string",
    "lastUpdateBy" : "string",
    "lastUpdateTime" : "string",
    "level" : 0,
    "name" : "string",
    "orderNum" : 0,
    "parentId" : "string",
    "parentName" : "string",
    "perms" : "string",
    "type" : 0,
    "url" : "string"
  } ],
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "icon" : "string",
  "id" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "level" : 0,
  "name" : "string",
  "orderNum" : 0,
  "parentId" : "string",
  "parentName" : "string",
  "perms" : "string",
  "type" : 0,
  "url" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="2be3383931ac385fce8af0858c5ae830"></a>
### 部门接口
Sys Dept Controller


<a name="deleteusingpost_1"></a>
#### 删除部门
```
POST /sys_dept/delete
```


##### 说明
批量删除


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**records**  <br>*必填*|records|< [SysDept](#sysdept) > array|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_dept/delete
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
[ {
  "children" : [ {
    "children" : [ "..." ],
    "createBy" : "string",
    "createTime" : "string",
    "delFlag" : 0,
    "id" : "string",
    "lastUpdateBy" : "string",
    "lastUpdateTime" : "string",
    "level" : 0,
    "name" : "string",
    "orderNum" : 0,
    "parentId" : "string",
    "parentName" : "string"
  } ],
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "id" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "level" : 0,
  "name" : "string",
  "orderNum" : 0,
  "parentId" : "string",
  "parentName" : "string"
} ]
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="findpageusingget"></a>
#### 查询部门树形结构的数据
```
GET /sys_dept/findTree
```


##### 说明
树形结构的数据


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_dept/findTree
```


###### 请求 header
```
json :
"string"
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="saveusingpost_1"></a>
#### 保存部门
```
POST /sys_dept/save
```


##### 说明
保存部门


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|令牌|string|
|**Body**|**record**  <br>*必填*|record|[SysDept](#sysdept)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[HttpResult](#httpresult)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/sys_dept/save
```


###### 请求 header
```
json :
"string"
```


###### 请求 body
```
json :
{
  "children" : [ {
    "children" : [ "..." ],
    "createBy" : "string",
    "createTime" : "string",
    "delFlag" : 0,
    "id" : "string",
    "lastUpdateBy" : "string",
    "lastUpdateTime" : "string",
    "level" : 0,
    "name" : "string",
    "orderNum" : 0,
    "parentId" : "string",
    "parentName" : "string"
  } ],
  "createBy" : "string",
  "createTime" : "string",
  "delFlag" : 0,
  "id" : "string",
  "lastUpdateBy" : "string",
  "lastUpdateTime" : "string",
  "level" : 0,
  "name" : "string",
  "orderNum" : 0,
  "parentId" : "string",
  "parentName" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```




<a name="definitions"></a>
## 定义

<a name="httpresult"></a>
### HttpResult

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `0`|integer (int32)|
|**data**  <br>*可选*|**样例** : `"object"`|object|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="link"></a>
### Link

|名称|说明|类型|
|---|---|---|
|**href**  <br>*可选*|**样例** : `"string"`|string|
|**templated**  <br>*可选*|**样例** : `true`|boolean|


<a name="loginbean"></a>
### LoginBean

|名称|说明|类型|
|---|---|---|
|**account**  <br>*可选*|**样例** : `"string"`|string|
|**captcha**  <br>*可选*|**样例** : `"string"`|string|
|**password**  <br>*可选*|**样例** : `"string"`|string|


<a name="a1a99db20c14165edbb7e38ee2c86a80"></a>
### Map«string,Link»
*类型* : < string, [Link](#link) > map


<a name="modelandview"></a>
### ModelAndView

|名称|说明|类型|
|---|---|---|
|**empty**  <br>*可选*|**样例** : `true`|boolean|
|**model**  <br>*可选*|**样例** : `"object"`|object|
|**modelMap**  <br>*可选*|**样例** : `{<br>  "string" : "object"<br>}`|< string, object > map|
|**reference**  <br>*可选*|**样例** : `true`|boolean|
|**status**  <br>*可选*|**样例** : `"string"`|enum (100, 101, 102, 103, 200, 201, 202, 203, 204, 205, 206, 207, 208, 226, 300, 301, 302, 303, 304, 305, 307, 308, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 426, 428, 429, 431, 451, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511)|
|**view**  <br>*可选*|**样例** : `"[view](#view)"`|[View](#view)|
|**viewName**  <br>*可选*|**样例** : `"string"`|string|


<a name="mypagerequest"></a>
### MyPageRequest

|名称|说明|类型|
|---|---|---|
|**pageNum**  <br>*可选*|**样例** : `0`|integer (int32)|
|**pageSize**  <br>*可选*|**样例** : `0`|integer (int32)|


<a name="sysconfig"></a>
### SysConfig
系统配置


|名称|说明|类型|
|---|---|---|
|**createBy**  <br>*可选*|创建人  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**delFlag**  <br>*可选*|删除标记  <br>**最小值** : `-128`  <br>**最大值** : `127`  <br>**样例** : `0`|integer (int32)|
|**description**  <br>*可选*|描述  <br>**样例** : `"string"`|string|
|**id**  <br>*可选*|主键id  <br>**样例** : `"string"`|string|
|**label**  <br>*可选*|标签  <br>**样例** : `"string"`|string|
|**lastUpdateBy**  <br>*可选*|上一次更新者  <br>**样例** : `"string"`|string|
|**lastUpdateTime**  <br>*可选*|上一次更新时间  <br>**样例** : `"string"`|string (date-time)|
|**remarks**  <br>*可选*|备注  <br>**样例** : `"string"`|string|
|**sort**  <br>*可选*|排序  <br>**样例** : `0`|integer (int64)|
|**type**  <br>*可选*|类型  <br>**样例** : `"string"`|string|
|**value**  <br>*可选*|值  <br>**样例** : `"string"`|string|


<a name="sysdept"></a>
### SysDept
部门


|名称|说明|类型|
|---|---|---|
|**children**  <br>*可选*|**样例** : `[ "[sysdept](#sysdept)" ]`|< [SysDept](#sysdept) > array|
|**createBy**  <br>*可选*|创建人  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**delFlag**  <br>*可选*|删除标记  <br>**最小值** : `-128`  <br>**最大值** : `127`  <br>**样例** : `0`|integer (int32)|
|**id**  <br>*可选*|主键id  <br>**样例** : `"string"`|string|
|**lastUpdateBy**  <br>*可选*|上一次更新者  <br>**样例** : `"string"`|string|
|**lastUpdateTime**  <br>*可选*|上一次更新时间  <br>**样例** : `"string"`|string (date-time)|
|**level**  <br>*可选*|**样例** : `0`|integer (int32)|
|**name**  <br>*可选*|名称  <br>**样例** : `"string"`|string|
|**orderNum**  <br>*可选*|排序值  <br>**样例** : `0`|integer (int32)|
|**parentId**  <br>*可选*|父级id  <br>**样例** : `"string"`|string|
|**parentName**  <br>*可选*|**样例** : `"string"`|string|


<a name="sysdict"></a>
### SysDict
基础模型，公共的字段属性


|名称|说明|类型|
|---|---|---|
|**createBy**  <br>*可选*|创建人  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**delFlag**  <br>*可选*|**最小值** : `-128`  <br>**最大值** : `127`**样例** : `0`|integer (int32)|
|**description**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|主键id  <br>**样例** : `"string"`|string|
|**label**  <br>*可选*|**样例** : `"string"`|string|
|**lastUpdateBy**  <br>*可选*|上一次更新者  <br>**样例** : `"string"`|string|
|**lastUpdateTime**  <br>*可选*|上一次更新时间  <br>**样例** : `"string"`|string (date-time)|
|**remarks**  <br>*可选*|**样例** : `"string"`|string|
|**sort**  <br>*可选*|**样例** : `0`|integer (int64)|
|**type**  <br>*可选*|**样例** : `"string"`|string|
|**value**  <br>*可选*|**样例** : `"string"`|string|


<a name="syslog"></a>
### SysLog
基础模型，公共的字段属性


|名称|说明|类型|
|---|---|---|
|**createBy**  <br>*可选*|创建人  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**id**  <br>*可选*|主键id  <br>**样例** : `"string"`|string|
|**ip**  <br>*可选*|**样例** : `"string"`|string|
|**lastUpdateBy**  <br>*可选*|上一次更新者  <br>**样例** : `"string"`|string|
|**lastUpdateTime**  <br>*可选*|上一次更新时间  <br>**样例** : `"string"`|string (date-time)|
|**method**  <br>*可选*|**样例** : `"string"`|string|
|**operation**  <br>*可选*|**样例** : `"string"`|string|
|**params**  <br>*可选*|**样例** : `"string"`|string|
|**time**  <br>*可选*|**样例** : `0`|integer (int64)|
|**userName**  <br>*可选*|**样例** : `"string"`|string|


<a name="sysloginlog"></a>
### SysLoginLog

|名称|说明|类型|
|---|---|---|
|**createTime**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `"string"`|string|
|**ip**  <br>*可选*|**样例** : `"string"`|string|
|**remark**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**样例** : `"string"`|string|
|**userName**  <br>*可选*|**样例** : `"string"`|string|


<a name="sysmenu"></a>
### SysMenu
基础模型，公共的字段属性


|名称|说明|类型|
|---|---|---|
|**children**  <br>*可选*|**样例** : `[ "[sysmenu](#sysmenu)" ]`|< [SysMenu](#sysmenu) > array|
|**createBy**  <br>*可选*|创建人  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**delFlag**  <br>*可选*|**最小值** : `-128`  <br>**最大值** : `127`**样例** : `0`|integer (int32)|
|**icon**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|主键id  <br>**样例** : `"string"`|string|
|**lastUpdateBy**  <br>*可选*|上一次更新者  <br>**样例** : `"string"`|string|
|**lastUpdateTime**  <br>*可选*|上一次更新时间  <br>**样例** : `"string"`|string (date-time)|
|**level**  <br>*可选*|**样例** : `0`|integer (int32)|
|**name**  <br>*可选*|**样例** : `"string"`|string|
|**orderNum**  <br>*可选*|**样例** : `0`|integer (int32)|
|**parentId**  <br>*可选*|**样例** : `"string"`|string|
|**parentName**  <br>*可选*|**样例** : `"string"`|string|
|**perms**  <br>*可选*|**样例** : `"string"`|string|
|**type**  <br>*可选*|**样例** : `0`|integer (int32)|
|**url**  <br>*可选*|**样例** : `"string"`|string|


<a name="sysrole"></a>
### SysRole
基础模型，公共的字段属性


|名称|说明|类型|
|---|---|---|
|**createBy**  <br>*可选*|创建人  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**delFlag**  <br>*可选*|**最小值** : `-128`  <br>**最大值** : `127`**样例** : `0`|integer (int32)|
|**id**  <br>*可选*|主键id  <br>**样例** : `"string"`|string|
|**lastUpdateBy**  <br>*可选*|上一次更新者  <br>**样例** : `"string"`|string|
|**lastUpdateTime**  <br>*可选*|上一次更新时间  <br>**样例** : `"string"`|string (date-time)|
|**name**  <br>*可选*|**样例** : `"string"`|string|
|**remark**  <br>*可选*|**样例** : `"string"`|string|


<a name="sysrolemenu"></a>
### SysRoleMenu
基础模型，公共的字段属性


|名称|说明|类型|
|---|---|---|
|**createBy**  <br>*可选*|创建人  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**id**  <br>*可选*|主键id  <br>**样例** : `"string"`|string|
|**lastUpdateBy**  <br>*可选*|上一次更新者  <br>**样例** : `"string"`|string|
|**lastUpdateTime**  <br>*可选*|上一次更新时间  <br>**样例** : `"string"`|string (date-time)|
|**menuId**  <br>*可选*|**样例** : `"string"`|string|
|**roleId**  <br>*可选*|**样例** : `"string"`|string|


<a name="sysuser"></a>
### SysUser
基础模型，公共的字段属性


|名称|说明|类型|
|---|---|---|
|**avatar**  <br>*可选*|**样例** : `"string"`|string|
|**createBy**  <br>*可选*|创建人  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**delFlag**  <br>*可选*|**最小值** : `-128`  <br>**最大值** : `127`**样例** : `0`|integer (int32)|
|**deptId**  <br>*可选*|**样例** : `"string"`|string|
|**deptName**  <br>*可选*|**样例** : `"string"`|string|
|**email**  <br>*可选*|**样例** : `"string"`|string|
|**id**  <br>*可选*|主键id  <br>**样例** : `"string"`|string|
|**lastUpdateBy**  <br>*可选*|上一次更新者  <br>**样例** : `"string"`|string|
|**lastUpdateTime**  <br>*可选*|上一次更新时间  <br>**样例** : `"string"`|string (date-time)|
|**mobile**  <br>*可选*|**样例** : `"string"`|string|
|**name**  <br>*可选*|**样例** : `"string"`|string|
|**nickName**  <br>*可选*|**样例** : `"string"`|string|
|**password**  <br>*可选*|**样例** : `"string"`|string|
|**roleNames**  <br>*可选*|**样例** : `"string"`|string|
|**salt**  <br>*可选*|**样例** : `"string"`|string|
|**status**  <br>*可选*|**最小值** : `-128`  <br>**最大值** : `127`**样例** : `0`|integer (int32)|
|**userRoles**  <br>*可选*|**样例** : `[ "[sysuserrole](#sysuserrole)" ]`|< [SysUserRole](#sysuserrole) > array|


<a name="sysuserrole"></a>
### SysUserRole
基础模型，公共的字段属性


|名称|说明|类型|
|---|---|---|
|**createBy**  <br>*可选*|创建人  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**id**  <br>*可选*|主键id  <br>**样例** : `"string"`|string|
|**lastUpdateBy**  <br>*可选*|上一次更新者  <br>**样例** : `"string"`|string|
|**lastUpdateTime**  <br>*可选*|上一次更新时间  <br>**样例** : `"string"`|string (date-time)|
|**roleId**  <br>*可选*|**样例** : `"string"`|string|
|**userId**  <br>*可选*|**样例** : `"string"`|string|


<a name="view"></a>
### View

|名称|说明|类型|
|---|---|---|
|**contentType**  <br>*可选*|**样例** : `"string"`|string|





