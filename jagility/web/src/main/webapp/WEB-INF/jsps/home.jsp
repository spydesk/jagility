<%@ include file="../includes/common-jsp-declarations.jsp" %>
<stripes:layout-render name="/WEB-INF/layouts/main-layout.jsp">
<stripes:layout-component name="body">
<fmt:message key="welcome"/>
<br/>
<fmt:message key="welcome2"/>
<br/>
<fmt:message key="welcome3"/>

<h1>Porttitor posuere</h1>
<div class="descr">Jun 13, 2006 by Vulputate</div>

<p>In hac habitasse platea dictumst. Duis porttitor. Sed vulputate elementum nisl. Vivamus et mi at arcu mattis iaculis. Nullam posuere tristique tortor. In bibendum. Aenean ornare, <a href="index.html">nunc eget pretium</a> porttitor, sem est pretium leo, non euismod nulla dui non diam. Pellentesque dictum faucibus leo. Vestibulum ac ante. Sed in est.</p>
<cite>Sed sodales nisl sit amet augue. Donec ultrices, augue ullamcorper posuere laoreet, turpis massa tristique justo, sed egestas metus magna sed purus.</cite>
<p>Aliquam risus justo, mollis in, laoreet a, consectetuer nec, risus. Nunc blandit sodales lacus. Nam luctus semper mi. In eu diam.</p>
<p>Fusce porta pede nec eros. Maecenas ipsum sem, interdum non, aliquam vitae, interdum nec, metus. Maecenas ornare lobortis risus. Etiam placerat varius mauris. Maecenas viverra. Sed feugiat. Donec mattis <a href="index.html">quam aliquam</a> risus. Nulla non felis sollicitudin urna blandit egestas. Integer et libero varius pede tristique ultricies. Cras nisl. Proin quis massa semper felis euismod ultricies.
</p>

<h1>Adipiscing</h1>
<div class="descr">Jun 11, 2006 by Laoreet</div>

<p>Aliquam risus justo, mollis in, laoreet a, consectetuer nec, risus. Nunc blandit sodales lacus. Nam luctus semper mi. In eu diam. Phasellus rutrum elit vel nisi. Cras mauris nulla, egestas quis, cursus at, venenatis ac, ante. Fusce accumsan enim et arcu. Duis sagittis libero at lacus. Suspendisse lacinia nulla eget urna.</p>
<ul>
<li>Tristique</li>
<li>Aenean</li>
<li>Pretium</li>
</ul>
<p>In hac habitasse platea dictumst. Duis porttitor. Sed vulputate elementum nisl. Vivamus et mi at arcu mattis iaculis. Nullam posuere tristique tortor. In bibendum. Aenean ornare, nunc eget pretium porttitor, sem est pretium leo, non euismod nulla dui non diam. Pellentesque dictum faucibus leo. Vestibulum ac ante. Sed in est. Sed sodales nisl sit amet augue. Donec ultrices, augue ullamcorper posuere laoreet, turpis massa tristique justo, sed egestas metus magna sed purus. Fusce eleifend, dui ut posuere auctor, justo elit posuere sapien, at blandit enim quam fringilla mi.</p>

<h1>Interdum</h1>
<div class="descr">May 24, 2006 by Lectus</div>

<p>Praesent nisi sem, bibendum in, ultrices sit amet, euismod sit amet, dui. Donec varius tincidunt nisi. Ut ut sapien. Integer porta. Fusce nibh. Curabitur pellentesque, lectus at <a href="index.html">volutpat interdum</a>, sem justo placerat elit, eget feugiat est leo tempor quam. Ut quis neque convallis magna consequat molestie. Nullam semper massa eget ligula. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque a nibh quis nunc volutpat aliquam</p>
<code>margin-bottom: 12px;
font: normal 1.1em "Lucida Sans Unicode",serif;
background: url(img/quote.gif) no-repeat;
padding-left: 28px;
color: #555;</code>
<p>Eget feugiat est leo tempor quam. Ut quis neque convallis magna consequat molestie.</p>

<table>
<thead><tr>
<th><a href="/some/link">Head 1</a></th>
<th>Head 2</th>
<th>Head 3</th>
</tr></thead>
<tbody>
<tr>
<td>some text</td>
<td><a href="/some/link#anchor">some text</a></td>
<td>some text</td>
</tr>
<tr>
<td>some long long long long long long long long long long long long long long long long long long long long long text</td>
<td><a href="/some/link#anchor">some long long long long long long long long long long long long long long long long long long long long long text</a></td>
<td>some long long long long long long long long long long long long long long long long long long long long long text</td>
</tr>
</tbody>
<tfoot>
<tr>
<td>footer A</td>
<td>footer B</td>
<td><a href="http://www.external.com/some/link#anchor">footer C</a></td>
</tr>
</tfoot>
</table>

<h1>Search</h1>
<form action="index.html">
<div>
<input type="text" name="search" class="styled" /> <input type="submit" value="submit" class="button" />
</div>
</form>

</stripes:layout-component>
</stripes:layout-render>