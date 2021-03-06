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

package com.hrms.model.impl;

import com.hrms.model.CandidateQualification;
import com.hrms.model.CandidateQualificationModel;
import com.hrms.model.CandidateQualificationSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CandidateQualification service. Represents a row in the &quot;HRMS_CandidateQualification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.hrms.model.CandidateQualificationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CandidateQualificationImpl}.
 * </p>
 *
 * @author yashpalsinh
 * @see CandidateQualificationImpl
 * @see com.hrms.model.CandidateQualification
 * @see com.hrms.model.CandidateQualificationModel
 * @generated
 */
@JSON(strict = true)
public class CandidateQualificationModelImpl extends BaseModelImpl<CandidateQualification>
	implements CandidateQualificationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a candidate qualification model instance should use the {@link com.hrms.model.CandidateQualification} interface instead.
	 */
	public static final String TABLE_NAME = "HRMS_CandidateQualification";
	public static final Object[][] TABLE_COLUMNS = {
			{ "candidateQualificationId", Types.BIGINT },
			{ "candidateId", Types.BIGINT },
			{ "degreeName", Types.VARCHAR },
			{ "mainSubject", Types.VARCHAR },
			{ "university", Types.VARCHAR },
			{ "score", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "createBy", Types.BIGINT },
			{ "modifiedBy", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table HRMS_CandidateQualification (candidateQualificationId LONG not null primary key,candidateId LONG,degreeName VARCHAR(75) null,mainSubject VARCHAR(75) null,university VARCHAR(75) null,score VARCHAR(75) null,startDate DATE null,endDate DATE null,createDate DATE null,modifiedDate DATE null,createBy LONG,modifiedBy LONG)";
	public static final String TABLE_SQL_DROP = "drop table HRMS_CandidateQualification";
	public static final String ORDER_BY_JPQL = " ORDER BY candidateQualification.candidateQualificationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY HRMS_CandidateQualification.candidateQualificationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.hrms.model.CandidateQualification"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.hrms.model.CandidateQualification"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CandidateQualification toModel(
		CandidateQualificationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CandidateQualification model = new CandidateQualificationImpl();

		model.setCandidateQualificationId(soapModel.getCandidateQualificationId());
		model.setCandidateId(soapModel.getCandidateId());
		model.setDegreeName(soapModel.getDegreeName());
		model.setMainSubject(soapModel.getMainSubject());
		model.setUniversity(soapModel.getUniversity());
		model.setScore(soapModel.getScore());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCreateBy(soapModel.getCreateBy());
		model.setModifiedBy(soapModel.getModifiedBy());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CandidateQualification> toModels(
		CandidateQualificationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CandidateQualification> models = new ArrayList<CandidateQualification>(soapModels.length);

		for (CandidateQualificationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.hrms.model.CandidateQualification"));

	public CandidateQualificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _candidateQualificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCandidateQualificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateQualificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateQualification.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateQualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateQualificationId", getCandidateQualificationId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("degreeName", getDegreeName());
		attributes.put("mainSubject", getMainSubject());
		attributes.put("university", getUniversity());
		attributes.put("score", getScore());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidateQualificationId = (Long)attributes.get(
				"candidateQualificationId");

		if (candidateQualificationId != null) {
			setCandidateQualificationId(candidateQualificationId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		String degreeName = (String)attributes.get("degreeName");

		if (degreeName != null) {
			setDegreeName(degreeName);
		}

		String mainSubject = (String)attributes.get("mainSubject");

		if (mainSubject != null) {
			setMainSubject(mainSubject);
		}

		String university = (String)attributes.get("university");

		if (university != null) {
			setUniversity(university);
		}

		String score = (String)attributes.get("score");

		if (score != null) {
			setScore(score);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createBy = (Long)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@JSON
	@Override
	public long getCandidateQualificationId() {
		return _candidateQualificationId;
	}

	@Override
	public void setCandidateQualificationId(long candidateQualificationId) {
		_candidateQualificationId = candidateQualificationId;
	}

	@JSON
	@Override
	public long getCandidateId() {
		return _candidateId;
	}

	@Override
	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	@JSON
	@Override
	public String getDegreeName() {
		if (_degreeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _degreeName;
		}
	}

	@Override
	public void setDegreeName(String degreeName) {
		_degreeName = degreeName;
	}

	@JSON
	@Override
	public String getMainSubject() {
		if (_mainSubject == null) {
			return StringPool.BLANK;
		}
		else {
			return _mainSubject;
		}
	}

	@Override
	public void setMainSubject(String mainSubject) {
		_mainSubject = mainSubject;
	}

	@JSON
	@Override
	public String getUniversity() {
		if (_university == null) {
			return StringPool.BLANK;
		}
		else {
			return _university;
		}
	}

	@Override
	public void setUniversity(String university) {
		_university = university;
	}

	@JSON
	@Override
	public String getScore() {
		if (_score == null) {
			return StringPool.BLANK;
		}
		else {
			return _score;
		}
	}

	@Override
	public void setScore(String score) {
		_score = score;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCreateBy() {
		return _createBy;
	}

	@Override
	public void setCreateBy(long createBy) {
		_createBy = createBy;
	}

	@JSON
	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CandidateQualification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CandidateQualification toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CandidateQualification)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CandidateQualificationImpl candidateQualificationImpl = new CandidateQualificationImpl();

		candidateQualificationImpl.setCandidateQualificationId(getCandidateQualificationId());
		candidateQualificationImpl.setCandidateId(getCandidateId());
		candidateQualificationImpl.setDegreeName(getDegreeName());
		candidateQualificationImpl.setMainSubject(getMainSubject());
		candidateQualificationImpl.setUniversity(getUniversity());
		candidateQualificationImpl.setScore(getScore());
		candidateQualificationImpl.setStartDate(getStartDate());
		candidateQualificationImpl.setEndDate(getEndDate());
		candidateQualificationImpl.setCreateDate(getCreateDate());
		candidateQualificationImpl.setModifiedDate(getModifiedDate());
		candidateQualificationImpl.setCreateBy(getCreateBy());
		candidateQualificationImpl.setModifiedBy(getModifiedBy());

		candidateQualificationImpl.resetOriginalValues();

		return candidateQualificationImpl;
	}

	@Override
	public int compareTo(CandidateQualification candidateQualification) {
		long primaryKey = candidateQualification.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateQualification)) {
			return false;
		}

		CandidateQualification candidateQualification = (CandidateQualification)obj;

		long primaryKey = candidateQualification.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<CandidateQualification> toCacheModel() {
		CandidateQualificationCacheModel candidateQualificationCacheModel = new CandidateQualificationCacheModel();

		candidateQualificationCacheModel.candidateQualificationId = getCandidateQualificationId();

		candidateQualificationCacheModel.candidateId = getCandidateId();

		candidateQualificationCacheModel.degreeName = getDegreeName();

		String degreeName = candidateQualificationCacheModel.degreeName;

		if ((degreeName != null) && (degreeName.length() == 0)) {
			candidateQualificationCacheModel.degreeName = null;
		}

		candidateQualificationCacheModel.mainSubject = getMainSubject();

		String mainSubject = candidateQualificationCacheModel.mainSubject;

		if ((mainSubject != null) && (mainSubject.length() == 0)) {
			candidateQualificationCacheModel.mainSubject = null;
		}

		candidateQualificationCacheModel.university = getUniversity();

		String university = candidateQualificationCacheModel.university;

		if ((university != null) && (university.length() == 0)) {
			candidateQualificationCacheModel.university = null;
		}

		candidateQualificationCacheModel.score = getScore();

		String score = candidateQualificationCacheModel.score;

		if ((score != null) && (score.length() == 0)) {
			candidateQualificationCacheModel.score = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			candidateQualificationCacheModel.startDate = startDate.getTime();
		}
		else {
			candidateQualificationCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			candidateQualificationCacheModel.endDate = endDate.getTime();
		}
		else {
			candidateQualificationCacheModel.endDate = Long.MIN_VALUE;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			candidateQualificationCacheModel.createDate = createDate.getTime();
		}
		else {
			candidateQualificationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			candidateQualificationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			candidateQualificationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		candidateQualificationCacheModel.createBy = getCreateBy();

		candidateQualificationCacheModel.modifiedBy = getModifiedBy();

		return candidateQualificationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{candidateQualificationId=");
		sb.append(getCandidateQualificationId());
		sb.append(", candidateId=");
		sb.append(getCandidateId());
		sb.append(", degreeName=");
		sb.append(getDegreeName());
		sb.append(", mainSubject=");
		sb.append(getMainSubject());
		sb.append(", university=");
		sb.append(getUniversity());
		sb.append(", score=");
		sb.append(getScore());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", createBy=");
		sb.append(getCreateBy());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.hrms.model.CandidateQualification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>candidateQualificationId</column-name><column-value><![CDATA[");
		sb.append(getCandidateQualificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidateId</column-name><column-value><![CDATA[");
		sb.append(getCandidateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>degreeName</column-name><column-value><![CDATA[");
		sb.append(getDegreeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mainSubject</column-name><column-value><![CDATA[");
		sb.append(getMainSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>university</column-name><column-value><![CDATA[");
		sb.append(getUniversity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>score</column-name><column-value><![CDATA[");
		sb.append(getScore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createBy</column-name><column-value><![CDATA[");
		sb.append(getCreateBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CandidateQualification.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CandidateQualification.class
		};
	private long _candidateQualificationId;
	private long _candidateId;
	private String _degreeName;
	private String _mainSubject;
	private String _university;
	private String _score;
	private Date _startDate;
	private Date _endDate;
	private Date _createDate;
	private Date _modifiedDate;
	private long _createBy;
	private long _modifiedBy;
	private CandidateQualification _escapedModel;
}