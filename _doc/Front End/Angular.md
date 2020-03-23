---
title: Angular
date: 2020-03-23 08:20:19
tags:
---

# Trial and Online IDE
Try [this](https://stackblitz.com/angular/narbplrvdxg?file=src%2Fapp%2Fapp.component.ts) to make your first app.
# Setup
1. Install Node.js
2. After the installation of Node.js, make sure npm is installed by using:
```
which npm
```
3. Install angular
```
npm install -g @angular/cli
```
4. Create a new workspace and Initial application
```
ng new my-app
```
5. Run the application
```
cd my-app
ng serve --open
```

# 术语
JavaScript (JS)
View
Service
[Decorator](#装饰器)
Metadata
Template
Markup
Dependency Injection (DI)，依赖注入。
Router

# 项目结构
* app.component.css
css样式表。
* app.component.html
html模板。
* app.component.spec.ts
单元测试用。
* app.component.ts
定义用。
* app.module.ts
根模板（the root module）

# NgModule（Angular的模块化系统）
* AppModule: a root module of every Angular app. 位于app.module.ts文件中。要启动应用，就要引导这个根模块。
下面的是一个简单的AppModule：
```typescript
import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
@NgModule({
    imports:      [ BrowserModule ],
    providers:    [ Logger ],
    declarations: [ AppComponent ],
    exports:      [ AppComponent ],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }
```

# 生成新的Module
```
ng generate module app-routing
```

# 关键字import与export
*** 把AppComponent放到export中是为了演示导出的语法，根模块没必要导出任何东西，因为其它模块永远不需要导入根模块。 ***
JS中，每个文件都是一个模块，能通过关键字export公开某些对象（这一点有点像java的public），然后其他JS模块能用关键词import来取得这些公开的对象（这一点和python的import类似）。
# Angular自带的库
每个Angular库都带有前缀@angular，比如@angular/core。
想要从core导入Component，可使用以下的语法：
```
import { Component } from '@angular/core';
```
和python的import...from长得很像。

* Lazy-loading: loading modules on demand. 这一点和python很像，只有需要的时候才加载模组。

# 界面（interface）
界面（interface）可以看作一种数据类型（data structure），比如string就是一种interface，有点像C里面的struct。
```typescript
export interface Hero {
  name: string;
}
```

# 组件（Components）
* 根组件（Root component）
* 组件（Component）
```typescript
@Component({selector:'???', templateUrl:'???.html', styleUrls:'???.css'})
export class ClassName {
  title = ''; //the title of this component.
  data  = {}; //the data to be used in html template.
}
```
* selector，css selector。
* templateUrl，link to the html template。
* template，直接用书写的html模板。不能和templateUrl一起使用，会有冲突。
```typescript
template: `
  <h3>{{hero.name}} says:</h3>
  <p>I, {{hero.name}}, am at your service, {{masterName}}.</p>
`
```
* styleUrls，link to the css style sheet。

# 装饰器
* 装饰器@Component()表示：随后的这个类是个组件。
* 装饰器@Injectable()表示：随后的元数据能把服务看作依赖注入到客户组件（DI）。

# 组件的生命周期（Lice Cycle）
## 引文：https://angular.cn/guide/lifecycle-hooks#oninit
* ngOnChanges()
当 Angular（重新）设置数据绑定输入属性时响应。 该方法接受当前和上一属性值的 SimpleChanges 对象。在 ngOnInit() 之前以及所绑定的一个或多个输入属性的值发生变化时都会调用。

* ngOnInit()
在 Angular 第一次显示数据绑定和设置指令/组件的输入属性之后，初始化指令/组件。在第一轮 ngOnChanges() 完成之后调用，只调用一次。

* ngDoCheck()
检测，并在发生 Angular 无法或不愿意自己检测的变化时作出反应。在每个变更检测周期中，紧跟在 ngOnChanges() 和 ngOnInit() 后面调用。

* ngAfterContentInit()
当 Angular 把外部内容投影进组件/指令的视图之后调用。第一次 ngDoCheck() 之后调用，只调用一次。

* ngAfterContentChecked()
每当 Angular 完成被投影组件内容的变更检测之后调用。ngAfterContentInit() 和每次 ngDoCheck() 之后调用

* ngAfterViewInit()
当 Angular 初始化完组件视图及其子视图之后调用。第一次 ngAfterContentChecked() 之后调用，只调用一次。

* ngAfterViewChecked()
每当 Angular 做完组件视图和子视图的变更检测之后调用。ngAfterViewInit() 和每次 ngAfterContentChecked() 之后调用。

* ngOnDestroy()
每当 Angular 每次销毁指令/组件之前调用并清扫。 在这儿反订阅可观察对象和分离事件处理器，以防内存泄漏（memory leak）。在 Angular 销毁指令/组件之前调用。

# constructor与ngOnInit之分
## 引文：
* 《[The essential difference between Constructor and ngOnInit in Angular](https://indepth.dev/the-essential-difference-between-constructor-and-ngoninit-in-angular/)》

Angular的bootstrap process主要有两步:
第一，constructing components tree（constructor）
第二，running change detection（ngOnInit）
初始化的话，constructor和ngOnInit，用哪一个都可以，看需求。

# 组件间的通讯
# 生成数据
## 数组
```typescript
data = [e1, e2, e3]
```
## Hash

```typescript
hash = {name: string, property: string}
```

# 注释（Comment）
在ts的语法和java很像，所以注释（comment）用的是//和/\*\*/。

# 例子：\*ngif（if, else）
```html
<div>
   <span *ngIf="isavailable; then c1 else c2">Condition is valid.</span>
   <ng-template #c1>Condition is valid</ng-template>
   <ng-template #c2>Condition is invalid</ng-template>
</div>
```

# 例子：event handler
app.component.html:
```html
<button (click)="myClickFunction($event)">Click Me</button>
```
app.component.ts
```typescript
import { Component } from '@angular/core';
@Component({
   selector: 'app-root',
   templateUrl: './app.component.html',
   styleUrls: ['./app.component.css']
})
export class AppComponent {
   myClickFunction(event) {
      alert("Button is clicked");
      console.log(event);
   }
}
```

# 例子，迭代重复：\*ngfor，
```html
<div *ngFor="let product of products" id="12">
  <h3>
      {{ "***"+product.name }}
  </h3>
</div>
```
语法：

```typescript
*ngfor="iteration logic"
```

以上的例子中，iteration logic是let product of products。
products是在其他ts文件中定义好的数组数据，这里假设
```
products = [{name: 'Phone XL'}, {name: 'Phone Mini'}, {name: 'Phone Standard'}]
```
ngfor的用法是迭代重复，以上例子会生成三个同样样式的元素：
```html
<div id="12"></div><div id="12"></div><div id="12"></div>
```

```
{{}}
```
是插值绑定，可以在里面放入需要显示的字符串。
效果：

# 例子，绑定属性：\[\]
```
<a [title]="product.name + ' $'+product.price"></a>
```
红字是属性名字，蓝字是属性内容。
以上例子会被转化为：
```
<a title="Phone Standard $299"></a>
```

# 管道（Pipes）与管道操作符（|）
管道，可用于数据的格式化。
```html
<!-- Default format: output 'Jun 15, 2015'-->
 <p>Today is {{today | date}}</p>
<!-- fullDate format: output 'Monday, June 15, 2015'-->
<p>The date is {{today | date:'fullDate'}}</p>
<!-- shortTime format: output '9:43 AM'-->
<p>The time is {{today | date:'shortTime'}}</p>
```

# 解决方案
### Search Filter
https://stackblitz.com/edit/angular-search-filter
```html
<h2>Products</h2>
<div class="search-hero">
  <input class="form-control" type="text" name="search" [(ngModel)]="searchText" autocomplete="off" placeholder="&#61442;  Start searching for a hero by id or name or country">
</div>
<div *ngFor="let product of products | filter:searchText" id="12">
  <h3>
      <a [title]="product.name + ' $'+product.price">
      {{ "***"+product.name }}
      </a>
  </h3>
</div>
```
and
```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { ProductListComponent } from './product-list/product-list.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule,
    FormsModule,
    RouterModule.forRoot([
      { path: '', component: ProductListComponent },
    ])
  ],
  declarations: [
    AppComponent,
    TopBarComponent,
    ProductListComponent
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
```
### Expansion Panel
https://material.angular.io/components/expansion/overview
### Auto Complete
https://material.angular.io/components/autocomplete/overview

### 输入类·Check Box, return bool
https://material.angular.io/components/checkbox/overview
描述：一个空框，可以打勾。
返回：有勾（true）／没勾（false）
### 输入类·Slide-Toggles, return bool
https://material.angular.io/components/slide-toggle/overview
描述：像拨动开关一样。
返回：开／关。
### 输入类·Input Box, return string
https://material.angular.io/components/input/overview
描述：可以直接输入字符串，然后传递到Component里去。
### 输入类·Input Box·Date Picker, return string
https://material.angular.io/components/datepicker/overview
描述：可以直接输入字符串的日期，或者点击图标开启日历，然后选择日期。
返回：描述日期的字符串。
### 输入类·Radio Box, return int
https://material.angular.io/components/radio/overview
### 收纳类·Floating Menu
描述：点击按钮后，弹出悬浮菜单。
https://material.angular.io/components/menu/overview
### 收纳类·Collapsible Tree
描述：点击列表展开。
https://material.angular.io/components/tree/overview
布局类·Divider
描述：在各段中插入横线。
https://material.angular.io/components/divider/overview
### 布局类·列表（List）
描述：按列表展示项目。
https://material.angular.io/cdk/overlay/overview
### 切换类·Navigation
描述：点击上方栏目切换版面内容。
https://stackblitz.com/angular/maynynaovyp?file=src%2Fapp%2Fapp-routing.module.ts
# 测试

