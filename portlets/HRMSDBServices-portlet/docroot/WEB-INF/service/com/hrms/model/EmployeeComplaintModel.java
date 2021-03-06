/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.hrms.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EmployeeComplaint service. Represents a row in the &quot;HRMS_EmployeeComplaint&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.hrms.model.impl.EmployeeComplaintModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.hrms.model.impl.EmployeeComplaintImpl}.
 * </p>
 *
 * @author yashpalsinh
 * @see EmployeeComplaint
 * @see com.hrms.model.impl.EmployeeComplaintImpl
 * @see com.hrms.model.impl.EmployeeComplaintModelImpl
 * @generated
 */
public interface EmployeeComplaintModel extends BaseModel<EmployeeComplaint> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee complaint model instance should use the {@link EmployeeComplaint} interface instead.
	 */

	/**
	 * Returns the primary key of this employee complaint.
	 *
	 * @return the primary key of this employee complaint
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee complaint.
	 *
	 * @param primaryKey the primary key of this employee complaint
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee complaint ID of this employee complaint.
	 *
	 * @return the employee complaint ID of this employee complaint
	 */
	public long getEmployeeComplaintId();

	/**
	 * Sets the employee complaint ID of this employee complaint.
	 *
	 * @param employeeComplaintId the employee complaint ID of this employee complaint
	 */
	public void setEmployeeComplaintId(long employeeComplaintId);

	/**
	 * Returns the user ID of this employee complaint.
	 *
	 * @return the user ID of this employee complaint
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this employee complaint.
	 *
	 * @param userId the user ID of this employee complaint
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee complaint.
	 *
	 * @return the user uuid of this employee complaint
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this employee complaint.
	 *
	 * @param userUuid the user uuid of this employee complaint
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this employee complaint.
	 *
	 * @return the group ID of this employee complaint
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this employee complaint.
	 *
	 * @param groupId the group ID of this employee complaint
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee complaint.
	 *
	 * @return the company ID of this employee complaint
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee complaint.
	 *
	 * @param companyId the company ID of this employee complaint
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the complaint title of this employee complaint.
	 *
	 * @return the complaint title of this employee complaint
	 */
	@AutoEscape
	public String getComplaintTitle();

	/**
	 * Sets the complaint title of this employee complaint.
	 *
	 * @param complaintTitle the complaint title of this employee complaint
	 */
	public void setComplaintTitle(String complaintTitle);

	/**
	 * Returns the complaint discription of this employee complaint.
	 *
	 * @return the complaint discription of this employee complaint
	 */
	@AutoEscape
	public String getComplaintDiscription();

	/**
	 * Sets the complaint discription of this employee complaint.
	 *
	 * @param complaintDiscription the complaint discription of this employee complaint
	 */
	public void setComplaintDiscription(String complaintDiscription);

	/**
	 * Returns the complaint from of this employee complaint.
	 *
	 * @return the complaint from of this employee complaint
	 */
	public long getComplaintFrom();

	/**
	 * Sets the complaint from of this employee complaint.
	 *
	 * @param complaintFrom the complaint from of this employee complaint
	 */
	public void setComplaintFrom(long complaintFrom);

	/**
	 * Returns the complaint date of this employee complaint.
	 *
	 * @return the complaint date of this employee complaint
	 */
	public Date getComplaintDate();

	/**
	 * Sets the complaint date of this employee complaint.
	 *
	 * @param complaintDate the complaint date of this employee complaint
	 */
	public void setComplaintDate(Date complaintDate);

	/**
	 * Returns the status of this employee complaint.
	 *
	 * @return the status of this employee complaint
	 */
	public boolean getStatus();

	/**
	 * Returns <code>true</code> if this employee complaint is status.
	 *
	 * @return <code>true</code> if this employee complaint is status; <code>false</code> otherwise
	 */
	public boolean isStatus();

	/**
	 * Sets whether this employee complaint is status.
	 *
	 * @param status the status of this employee complaint
	 */
	public void setStatus(boolean status);

	/**
	 * Returns the modified date of this employee complaint.
	 *
	 * @return the modified date of this employee complaint
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee complaint.
	 *
	 * @param modifiedDate the modified date of this employee complaint
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the create by of this employee complaint.
	 *
	 * @return the create by of this employee complaint
	 */
	public long getCreateBy();

	/**
	 * Sets the create by of this employee complaint.
	 *
	 * @param createBy the create by of this employee complaint
	 */
	public void setCreateBy(long createBy);

	/**
	 * Returns the modified by of this employee complaint.
	 *
	 * @return the modified by of this employee complaint
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this employee complaint.
	 *
	 * @param modifiedBy the modified by of this employee complaint
	 */
	public void setModifiedBy(long modifiedBy);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(EmployeeComplaint employeeComplaint);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmployeeComplaint> toCacheModel();

	@Override
	public EmployeeComplaint toEscapedModel();

	@Override
	public EmployeeComplaint toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}