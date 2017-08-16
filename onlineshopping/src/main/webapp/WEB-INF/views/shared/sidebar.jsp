<h1 class="my-4">Products</h1>
                <div class="list-group">
                
                <c:forEach items="${categories}"  var="list" >  
                
                    <a href="${contextRoot}/show/category/${list.id}/products" class="list-group-item" id="a_${list.name}">${list.name}</a>
                 
                     </c:forEach>
                    
                </div>