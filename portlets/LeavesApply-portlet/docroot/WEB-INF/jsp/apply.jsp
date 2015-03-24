
<%@include file="/WEB-INF/jsp/init.jsp"%>
<portlet:actionURL var="applyLeave">
	<portlet:param name="action" value="applyLeave"/>
</portlet:actionURL>

<portlet:renderURL var="displayURL">
	<portlet:param name="action" value="display"/>
</portlet:renderURL>
<aui:form action="<%=applyLeave %>" method="post" name="ApplyLeaveFm">
	<aui:input name="employeeName" label="EmployeeName" type="text" inlineLabel="true" />
	<aui:select label="LeaveName" name="leaveName">
		<c:forEach
			items="<%=LeaveLocalServiceUtil.getLeaves(-1, -1)%>"
			var="employeeLeave">
			<aui:option value="${employeeLeave.leaveId}"
					selected="${leaveApply.leaveID ==employeeLeave.leaveId?'true':'false'}">
					${employeeLeave.leaveName }
		
			</aui:option>
		</c:forEach>
	</aui:select>
	<aui:input name="entitlement" label="Reason" type="text" inlineLabel="true"/>
	<aui:select name="leaveDuration" label="LeaveDuration">
		<aui:option value="Full Day"/>
		<aui:option value="Half Day"/>
	</aui:select>
	<label class="aui-field-label"
				for="_corporatenewsadmin_WAR_CorporateNewsportlet_smallFile">
				StartDate</label>
	<label class="aui-field-label"
				for="_corporatenewsadmin_WAR_CorporateNewsportlet_smallFile">End
				Date</label>
		
	 <div id="myDatePicker" class="aui-datepicker aui-datepicker-display aui-helper-clearfix">
	</div>
<aui:input name="startDateHidden" id="startDateHidden" type="hidden"  value="" ></aui:input>

	
<%-- 	<aui:input name="leaveFrom" label="LeaveFrom" type="timeZone"/> --%>
<%-- 	<aui:input name="leaveTo" label="LeaveTo" type="timeZone"/> --%>
<%-- 	<aui:input name="leaveDate" label="LeaveDate" type=""/> --%>
<%-- 	<aui:input name="leavePeriod" label="LeavePeriod" type=""></aui:input> --%>


<aui:script>
var startDatePicker;
AUI().use(
  'aui-datepicker',
  function(A) {
    startDatePicker=new A.DatePickerSelect(
      {
     appendOrder: ['m', 'd', 'y'],
        calendar: {
        dateFormat: '%m/%d/%Y',
         
        }
      }
    ).render('#myDatePicker');

 function submitForm(){
       var startDate;
       var endDate;   
    A.one("#<portlet:namespace/>startDateHidden").
set('value',startDatePicker.calendar.getFormattedSelectedDates ()[0]); 
  document.<portlet:namespace/>date.submit();
}
  });
</aui:script>
</aui:form>