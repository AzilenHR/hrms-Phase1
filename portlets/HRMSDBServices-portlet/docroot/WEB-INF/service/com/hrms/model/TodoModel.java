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

/**
 * The base model interface for the Todo service. Represents a row in the &quot;HRMS_Todo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.hrms.model.impl.TodoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.hrms.model.impl.TodoImpl}.
 * </p>
 *
 * @author yashpalsinh
 * @see Todo
 * @see com.hrms.model.impl.TodoImpl
 * @see com.hrms.model.impl.TodoModelImpl
 * @generated
 */
public interface TodoModel extends BaseModel<Todo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a todo model instance should use the {@link Todo} interface instead.
	 */

	/**
	 * Returns the primary key of this todo.
	 *
	 * @return the primary key of this todo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this todo.
	 *
	 * @param primaryKey the primary key of this todo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the task ID of this todo.
	 *
	 * @return the task ID of this todo
	 */
	public long getTaskId();

	/**
	 * Sets the task ID of this todo.
	 *
	 * @param taskId the task ID of this todo
	 */
	public void setTaskId(long taskId);

	/**
	 * Returns the user ID of this todo.
	 *
	 * @return the user ID of this todo
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this todo.
	 *
	 * @param userId the user ID of this todo
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this todo.
	 *
	 * @return the user uuid of this todo
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this todo.
	 *
	 * @param userUuid the user uuid of this todo
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the date of this todo.
	 *
	 * @return the date of this todo
	 */
	@AutoEscape
	public String getDate();

	/**
	 * Sets the date of this todo.
	 *
	 * @param date the date of this todo
	 */
	public void setDate(String date);

	/**
	 * Returns the task details of this todo.
	 *
	 * @return the task details of this todo
	 */
	@AutoEscape
	public String getTaskDetails();

	/**
	 * Sets the task details of this todo.
	 *
	 * @param taskDetails the task details of this todo
	 */
	public void setTaskDetails(String taskDetails);

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
	public int compareTo(Todo todo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Todo> toCacheModel();

	@Override
	public Todo toEscapedModel();

	@Override
	public Todo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}