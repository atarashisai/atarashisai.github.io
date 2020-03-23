### by class
```css
.class
```
```html
<tag class="class">
```
### by id
```css
#id
```
```html
<tag id="id">
```
### every element
```css
*
```
所有元素
### by element
```css
tag
```
```html
<tag>
```
### both a and b
```css
a, b
```
```html
<a>
<b>
```
### select descendant
```css
pa desc
```
```html
<pa>...<desc>
```
### select child
```css
pa > child
```
```html
<pa><child>
```
### right after
```css
a + b
```
```html
<a></a><b></b>
```
### after
```css
a~b
```
```html
<a></a>....<b></b>
```
### attribute
```css
[attr]
```
```html
<e attr>
```
### attribute w/ value
```css
[attr=value]
[attr="value"]
```
```html
<e attr="value">
```
### partial attribute value
```css
[attr~=alu]
```
```html
<e attr="value">
```
### partial attribute value
```css
[attr*=alu]
```
```html
<e attr="value">
```
### attribute starting with X
```css
[attr|=X]
```
```html
<e attr="Xelem">
```
### attribute starting with X
```css
[attr^=X]
```
```html
<e attr="Xelem">
```
### attribute ending with Z
```css
[attr$=Z]
```
```html
<e attr="elem.Z">
```
### active link
```css
a:active
```
```html
<a>
```
### insert content after
```css
e::after {content: "string";}
```
### insert content before
```css
e::before {content: "string";}
```
### checked input
```css
input:checked
```
### disabled input
```css
input:disabled
```
### enabled input
```css
input:enabled
```
### single (no child)
```css
e:empty
```
### select every first child of its parent
```css
e:first-child
```
### select every child that is the first X type element of its parent
```css
e:first-of-type
```
### select the first letter of the text node
```css
e:first-letter
```
### first-line
```css
e::first-line
```
### the element having focus
```css
e:focus
```
### the element having mouse over
```css
e:hover
```
