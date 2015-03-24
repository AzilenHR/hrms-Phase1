<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL var="addTaskURL">
	<portlet:param name="action" value="addTask"/>
</portlet:actionURL>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  
  <portlet:resourceURL id="saveTask" var="saveTask"></portlet:resourceURL>
  
  
<script type="text/javascript">
$('document').ready(function(){
	
	$('#datepicker').datepicker({
	    dateFormat: 'dd-mm-yy',
	    numberOfMonths: 1,
	    onSelect: function(selected,evnt) {
	         updateAb(selected);
	    		}
	});
	
	$("#addTask").click(function(){
		
		var ur="<%=saveTask.toString()%>&<portlet:namespace/>date="+$('#date').val()+"&<portlet:namespace/>task="+$('#task').val();
		
		alert(ur);
		
			 $.ajax({
						 url:ur, 
						 success: function(result){
							 alert("result"+result.forms[0].date);
							 var htmlData='<table id=tasktable>';
							 for(i=0;i<result.forms.length;i++){
								 htmlData+="<tr><td>"+result.forms[i].date+"</td><td>"+result.forms[i].detail+"</td></tr>";
							 }
							htmlData+='</table>';
							alert(html)
							 $("#myData").html(htmlData);			
					    }});
				});
	
});
function updateAb(value){
		$("div#task-div").dialog ({
			height : 380,
			widht : 400
				});
    $('#date').val(value);    
}



</script>

<body>
	<div id="datepicker"></div>
	<div id="task-div" title="Task Managment" style="display:none;">
		<form id="add">
			<label>Date</label>	
			<input type="text" id="date" name="<portlet:namespace/>date" />
			<label>Task</label>
			<textarea rows="4" name="<portlet:namespace/>task"  id="task"></textarea>
			<br>
			<input type="button" value="Add Task" id="addTask"/> 
		</form>
	</div>
</body>