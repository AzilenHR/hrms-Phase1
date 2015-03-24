<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<portlet:actionURL var="addURL">
	<portlet:param name="action" value="addURL"/>
</portlet:actionURL>

<portlet:renderURL var="displayURL">
	<portlet:param name="action" value="displayURL"/>
</portlet:renderURL>


<aui:form method="Post" action="${addURL}" name="LeaveFm">
	 <aui:layout>
	 <div class="heading">
		<aui:column> 
 			Leaves Types	 
 		</aui:column> 
 		</div>
 		<br> 
			
 			<div align="center">Edit Leave Type</div> 
		
		
 		</aui:layout> 
 		<aui:layout> 
 		<aui:column > 
 			<div id="textBox"> 
 			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
 				<aui:input name="ID" type="hidden" value="${leave.leaveId }"></aui:input> 
 				<aui:input name="leaveName" value="${leave.leaveName }" label="Title" type="text" inlineLabel="true"/> 
	
 				<aui:input name="LeavesAllowedPerYear" value="${leave.leavesAllowedPerYear }" label="Leaves Allowed Per Year" type="int" inlineLabel="true"   last="true"/> 
 			</div> 
 			<div></div> 
 			<div id="drop"> 
 			<aui:select  label="LeaveType" name="LeaveType" id="selectedLeave" inlineLabel="true" value="${leave.leaveType }">
 				<aui:option value="Paid Leave" >Paid Leave</aui:option> 
 				<aui:option  value="Unpaid Leave">Unpaid Leave</aui:option> 
 			</aui:select> 
 			</div> 
 		</aui:column> 

	
 		<aui:column style="float:right;"> 
 		<div id="drop"> 
 			<aui:select label="carryOver" name="carryOver" inlineLabel="true" cssClass="drop" value="${leave.carryOver }"> 
 				<aui:option  value="yes">yes</aui:option> 
 				<aui:option  value="no">no</aui:option> 
 			</aui:select> 
 			
 			<div id="textBox">
 			
				<aui:input name="carryOverLimit" inlineLabel="true" value="${leave.carryOverLimit }">
					<aui:validator name="max"  errorMessage="please enter only upto 10">10</aui:validator>
				</aui:input>
				
			</div>
			
			
 			<aui:select label="encachement" name="encachement" inlineLabel="true" value="${leave.encachement }"> 
				<aui:option  value="yes">yes</aui:option> 
 				<aui:option  value="no">no</aui:option> 
			</aui:select> 
	
 			
			<aui:select name="Status" label="Status" inlineLabel="true">
				<option  value="true"	${leave.status == true ? 'selected': ''}>Active</option>
				<option  value="false"	${leave.status != true ? 'selected': ''}>Inactive</option>
		</aui:select>
 		</div> 
 		</aui:column> 
		
 	</aui:layout> 


	<div align="center">
		<aui:button name="EditLeaveType" id="EditLeaveType" type="submit" value="Edit Leave Type" inlineLabel="true" align="center" />
	</div>
 
	</aui:form>
	
	




