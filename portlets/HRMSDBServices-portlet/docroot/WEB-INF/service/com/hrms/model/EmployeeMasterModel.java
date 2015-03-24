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
 * The base model interface for the EmployeeMaster service. Represents a row in the &quot;HRMS_EmployeeMaster&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.hrms.model.impl.EmployeeMasterModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.hrms.model.impl.EmployeeMasterImpl}.
 * </p>
 *
 * @author yashpalsinh
 * @see EmployeeMaster
 * @see com.hrms.model.impl.EmployeeMasterImpl
 * @see com.hrms.model.impl.EmployeeMasterModelImpl
 * @generated
 */
public interface EmployeeMasterModel extends BaseModel<EmployeeMaster> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee master model instance should use the {@link EmployeeMaster} interface instead.
	 */

	/**
	 * Returns the primary key of this employee master.
	 *
	 * @return the primary key of this employee master
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee master.
	 *
	 * @param primaryKey the primary key of this employee master
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee master ID of this employee master.
	 *
	 * @return the employee master ID of this employee master
	 */
	public long getEmployeeMasterId();

	/**
	 * Sets the employee master ID of this employee master.
	 *
	 * @param employeeMasterId the employee master ID of this employee master
	 */
	public void setEmployeeMasterId(long employeeMasterId);

	/**
	 * Returns the employee ID of this employee master.
	 *
	 * @return the employee ID of this employee master
	 */
	@AutoEscape
	public String getEmployeeId();

	/**
	 * Sets the employee ID of this employee master.
	 *
	 * @param employeeId the employee ID of this employee master
	 */
	public void setEmployeeId(String employeeId);

	/**
	 * Returns the user ID of this employee master.
	 *
	 * @return the user ID of this employee master
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this employee master.
	 *
	 * @param userId the user ID of this employee master
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee master.
	 *
	 * @return the user uuid of this employee master
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this employee master.
	 *
	 * @param userUuid the user uuid of this employee master
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the gender of this employee master.
	 *
	 * @return the gender of this employee master
	 */
	public int getGender();

	/**
	 * Sets the gender of this employee master.
	 *
	 * @param gender the gender of this employee master
	 */
	public void setGender(int gender);

	/**
	 * Returns the date of birth of this employee master.
	 *
	 * @return the date of birth of this employee master
	 */
	public Date getDateOfBirth();

	/**
	 * Sets the date of birth of this employee master.
	 *
	 * @param dateOfBirth the date of birth of this employee master
	 */
	public void setDateOfBirth(Date dateOfBirth);

	/**
	 * Returns the joining date of this employee master.
	 *
	 * @return the joining date of this employee master
	 */
	public Date getJoiningDate();

	/**
	 * Sets the joining date of this employee master.
	 *
	 * @param joiningDate the joining date of this employee master
	 */
	public void setJoiningDate(Date joiningDate);

	/**
	 * Returns the leaving date of this employee master.
	 *
	 * @return the leaving date of this employee master
	 */
	public Date getLeavingDate();

	/**
	 * Sets the leaving date of this employee master.
	 *
	 * @param leavingDate the leaving date of this employee master
	 */
	public void setLeavingDate(Date leavingDate);

	/**
	 * Returns the marital status of this employee master.
	 *
	 * @return the marital status of this employee master
	 */
	public int getMaritalStatus();

	/**
	 * Sets the marital status of this employee master.
	 *
	 * @param maritalStatus the marital status of this employee master
	 */
	public void setMaritalStatus(int maritalStatus);

	/**
	 * Returns the nationality of this employee master.
	 *
	 * @return the nationality of this employee master
	 */
	@AutoEscape
	public String getNationality();

	/**
	 * Sets the nationality of this employee master.
	 *
	 * @param nationality the nationality of this employee master
	 */
	public void setNationality(String nationality);

	/**
	 * Returns the employee designation ID of this employee master.
	 *
	 * @return the employee designation ID of this employee master
	 */
	public int getEmployeeDesignationId();

	/**
	 * Sets the employee designation ID of this employee master.
	 *
	 * @param employeeDesignationId the employee designation ID of this employee master
	 */
	public void setEmployeeDesignationId(int employeeDesignationId);

	/**
	 * Returns the employee department ID of this employee master.
	 *
	 * @return the employee department ID of this employee master
	 */
	public int getEmployeeDepartmentId();

	/**
	 * Sets the employee department ID of this employee master.
	 *
	 * @param employeeDepartmentId the employee department ID of this employee master
	 */
	public void setEmployeeDepartmentId(int employeeDepartmentId);

	/**
	 * Returns the employee sub department ID of this employee master.
	 *
	 * @return the employee sub department ID of this employee master
	 */
	public int getEmployeeSubDepartmentId();

	/**
	 * Sets the employee sub department ID of this employee master.
	 *
	 * @param employeeSubDepartmentId the employee sub department ID of this employee master
	 */
	public void setEmployeeSubDepartmentId(int employeeSubDepartmentId);

	/**
	 * Returns the employee type ID of this employee master.
	 *
	 * @return the employee type ID of this employee master
	 */
	public int getEmployeeTypeId();

	/**
	 * Sets the employee type ID of this employee master.
	 *
	 * @param employeeTypeId the employee type ID of this employee master
	 */
	public void setEmployeeTypeId(int employeeTypeId);

	/**
	 * Returns the recruited on basis of of this employee master.
	 *
	 * @return the recruited on basis of of this employee master
	 */
	@AutoEscape
	public String getRecruitedOnBasisOf();

	/**
	 * Sets the recruited on basis of of this employee master.
	 *
	 * @param recruitedOnBasisOf the recruited on basis of of this employee master
	 */
	public void setRecruitedOnBasisOf(String recruitedOnBasisOf);

	/**
	 * Returns the recruited by of this employee master.
	 *
	 * @return the recruited by of this employee master
	 */
	public long getRecruitedBy();

	/**
	 * Sets the recruited by of this employee master.
	 *
	 * @param recruitedBy the recruited by of this employee master
	 */
	public void setRecruitedBy(long recruitedBy);

	/**
	 * Returns the create by of this employee master.
	 *
	 * @return the create by of this employee master
	 */
	public int getCreateBy();

	/**
	 * Sets the create by of this employee master.
	 *
	 * @param createBy the create by of this employee master
	 */
	public void setCreateBy(int createBy);

	/**
	 * Returns the modified by of this employee master.
	 *
	 * @return the modified by of this employee master
	 */
	public int getModifiedBy();

	/**
	 * Sets the modified by of this employee master.
	 *
	 * @param modifiedBy the modified by of this employee master
	 */
	public void setModifiedBy(int modifiedBy);

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
	public int compareTo(EmployeeMaster employeeMaster);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmployeeMaster> toCacheModel();

	@Override
	public EmployeeMaster toEscapedModel();

	@Override
	public EmployeeMaster toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}