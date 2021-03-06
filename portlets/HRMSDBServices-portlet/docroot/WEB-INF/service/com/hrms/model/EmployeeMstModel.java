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
 * The base model interface for the EmployeeMst service. Represents a row in the &quot;HRMS_EmployeeMst&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.hrms.model.impl.EmployeeMstModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.hrms.model.impl.EmployeeMstImpl}.
 * </p>
 *
 * @author yashpalsinh
 * @see EmployeeMst
 * @see com.hrms.model.impl.EmployeeMstImpl
 * @see com.hrms.model.impl.EmployeeMstModelImpl
 * @generated
 */
public interface EmployeeMstModel extends BaseModel<EmployeeMst> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee mst model instance should use the {@link EmployeeMst} interface instead.
	 */

	/**
	 * Returns the primary key of this employee mst.
	 *
	 * @return the primary key of this employee mst
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee mst.
	 *
	 * @param primaryKey the primary key of this employee mst
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee mst ID of this employee mst.
	 *
	 * @return the employee mst ID of this employee mst
	 */
	public long getEmployeeMstId();

	/**
	 * Sets the employee mst ID of this employee mst.
	 *
	 * @param employeeMstId the employee mst ID of this employee mst
	 */
	public void setEmployeeMstId(long employeeMstId);

	/**
	 * Returns the employee ID of this employee mst.
	 *
	 * @return the employee ID of this employee mst
	 */
	@AutoEscape
	public String getEmployeeId();

	/**
	 * Sets the employee ID of this employee mst.
	 *
	 * @param employeeId the employee ID of this employee mst
	 */
	public void setEmployeeId(String employeeId);

	/**
	 * Returns the user ID of this employee mst.
	 *
	 * @return the user ID of this employee mst
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this employee mst.
	 *
	 * @param userId the user ID of this employee mst
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee mst.
	 *
	 * @return the user uuid of this employee mst
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this employee mst.
	 *
	 * @param userUuid the user uuid of this employee mst
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the gender of this employee mst.
	 *
	 * @return the gender of this employee mst
	 */
	public boolean getGender();

	/**
	 * Returns <code>true</code> if this employee mst is gender.
	 *
	 * @return <code>true</code> if this employee mst is gender; <code>false</code> otherwise
	 */
	public boolean isGender();

	/**
	 * Sets whether this employee mst is gender.
	 *
	 * @param gender the gender of this employee mst
	 */
	public void setGender(boolean gender);

	/**
	 * Returns the date of birth of this employee mst.
	 *
	 * @return the date of birth of this employee mst
	 */
	public Date getDateOfBirth();

	/**
	 * Sets the date of birth of this employee mst.
	 *
	 * @param dateOfBirth the date of birth of this employee mst
	 */
	public void setDateOfBirth(Date dateOfBirth);

	/**
	 * Returns the joining date of this employee mst.
	 *
	 * @return the joining date of this employee mst
	 */
	public Date getJoiningDate();

	/**
	 * Sets the joining date of this employee mst.
	 *
	 * @param joiningDate the joining date of this employee mst
	 */
	public void setJoiningDate(Date joiningDate);

	/**
	 * Returns the leaving date of this employee mst.
	 *
	 * @return the leaving date of this employee mst
	 */
	public Date getLeavingDate();

	/**
	 * Sets the leaving date of this employee mst.
	 *
	 * @param leavingDate the leaving date of this employee mst
	 */
	public void setLeavingDate(Date leavingDate);

	/**
	 * Returns the maritual status of this employee mst.
	 *
	 * @return the maritual status of this employee mst
	 */
	public int getMaritualStatus();

	/**
	 * Sets the maritual status of this employee mst.
	 *
	 * @param maritualStatus the maritual status of this employee mst
	 */
	public void setMaritualStatus(int maritualStatus);

	/**
	 * Returns the nationality of this employee mst.
	 *
	 * @return the nationality of this employee mst
	 */
	@AutoEscape
	public String getNationality();

	/**
	 * Sets the nationality of this employee mst.
	 *
	 * @param nationality the nationality of this employee mst
	 */
	public void setNationality(String nationality);

	/**
	 * Returns the employee designation ID of this employee mst.
	 *
	 * @return the employee designation ID of this employee mst
	 */
	public long getEmployeeDesignationId();

	/**
	 * Sets the employee designation ID of this employee mst.
	 *
	 * @param employeeDesignationId the employee designation ID of this employee mst
	 */
	public void setEmployeeDesignationId(long employeeDesignationId);

	/**
	 * Returns the employee department ID of this employee mst.
	 *
	 * @return the employee department ID of this employee mst
	 */
	public long getEmployeeDepartmentId();

	/**
	 * Sets the employee department ID of this employee mst.
	 *
	 * @param employeeDepartmentId the employee department ID of this employee mst
	 */
	public void setEmployeeDepartmentId(long employeeDepartmentId);

	/**
	 * Returns the employee sub department ID of this employee mst.
	 *
	 * @return the employee sub department ID of this employee mst
	 */
	public long getEmployeeSubDepartmentId();

	/**
	 * Sets the employee sub department ID of this employee mst.
	 *
	 * @param employeeSubDepartmentId the employee sub department ID of this employee mst
	 */
	public void setEmployeeSubDepartmentId(long employeeSubDepartmentId);

	/**
	 * Returns the employee recruited by of this employee mst.
	 *
	 * @return the employee recruited by of this employee mst
	 */
	public long getEmployeeRecruitedBy();

	/**
	 * Sets the employee recruited by of this employee mst.
	 *
	 * @param employeeRecruitedBy the employee recruited by of this employee mst
	 */
	public void setEmployeeRecruitedBy(long employeeRecruitedBy);

	/**
	 * Returns the employee type of this employee mst.
	 *
	 * @return the employee type of this employee mst
	 */
	@AutoEscape
	public String getEmployeeType();

	/**
	 * Sets the employee type of this employee mst.
	 *
	 * @param employeeType the employee type of this employee mst
	 */
	public void setEmployeeType(String employeeType);

	/**
	 * Returns the create by of this employee mst.
	 *
	 * @return the create by of this employee mst
	 */
	public long getCreateBy();

	/**
	 * Sets the create by of this employee mst.
	 *
	 * @param createBy the create by of this employee mst
	 */
	public void setCreateBy(long createBy);

	/**
	 * Returns the modified by of this employee mst.
	 *
	 * @return the modified by of this employee mst
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this employee mst.
	 *
	 * @param modifiedBy the modified by of this employee mst
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
	public int compareTo(EmployeeMst employeeMst);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmployeeMst> toCacheModel();

	@Override
	public EmployeeMst toEscapedModel();

	@Override
	public EmployeeMst toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}