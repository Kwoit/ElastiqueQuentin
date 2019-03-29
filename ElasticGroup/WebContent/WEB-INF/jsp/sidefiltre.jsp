<%@page import="bean.BeanBrowser"%>
<%@page import="bean.BlocFiltre"%>
<%@page import="bean.Filtre"%>
<%@page import="service.Service"%>

<form  method="post" action="frontcontroller?cmd=CommandFiltre">
	<input name='btnConnect' type='submit' value='Filtrer' />
	<% 	for (BlocFiltre indiceBlocFiltre : Service.getSessionBeanBrowser(request).getListBlocFiltre()) { %>
			<fieldset id="indiceBlocFiltre.getFieldIdBlocFiltre()">
			
			<legend><%= indiceBlocFiltre.getLibelleBlocFiltre() %></legend>
			
			<% 	for (Filtre indiceFiltre : indiceBlocFiltre.getListFiltre()) { %>
					<div>
					<input type="checkbox"
					id="<%= indiceBlocFiltre.getIdBlocFiltre()+ " " +indiceFiltre.getIdFiltre() %>"
					name="<%= indiceBlocFiltre.getIdBlocFiltre()+ " " +indiceFiltre.getIdFiltre() %>"
					<%= indiceFiltre.getChecked()%>> 
					<label for="<%= indiceBlocFiltre.getLibelleBlocFiltre()+ " " +indiceFiltre.getLibelleFiltre() %>">
					<%	if( indiceFiltre.getColorFiltre() != null) { %>
							<div
								style='	width:30px;
										height:20px; 
										display:inline-block; 
										background-color:<%= indiceFiltre.getColorFiltre() %>'>
							</div> 
					<%	} %> 
					<%= indiceFiltre.getLibelleFiltre() %>
				</label> 
				</div>
			<%	} %>
			</div>
			</fieldset>
	<%	} %>
</form>