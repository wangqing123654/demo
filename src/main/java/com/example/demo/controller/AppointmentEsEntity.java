package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: emr
 * @description: 预约Es实体
 * @author: liujh
 * @create: 2020-10-21 17:39
 **/
@Data
@Document(indexName = "development-rytime-appointment", type = "appointment", shards = 5, replicas = 1, indexStoreType = "fs", refreshInterval = "-1")
public class AppointmentEsEntity implements Serializable {
	private static final long serialVersionUID = 7771038336756652200L;

	/**
	 * 预约ID
	 */
	@Id
	private Long id;

	/**
	 * 患者ID
	 */
	private Long patientId;

	/**
	 * 档案号
	 */
	private String fileNumber;

	/**
	 * 患者姓名
	 */
	private String name;

	/**
	 * 性别 1男 2女 其他 （未知）
	 */
	private Integer sex;

	/**
	 * 电话
	 */
	private String oftenTel;

	/**
	 * 与电话关系
	 */
	private String oftenTelRelation;

	/**
	 * 年龄
	 */
	private String age;

	/**
	 * 生日
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birthday;

	/**
	 * 欠款
	 */
	private String arrears;

	/**
	 * VIP名称 1是
	 */
	private String vipGrade;

	/**
	 * label标签
	 */
	private List<String> labelList;

	/**
	 * 过敏史标签
	 */
	private List<String> allergyList;

	/**
	 * 预约事项 == 预约主诉
	 */
	private String currentCure;

	/**
	 * 预约日期
	 */
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    private Date appointmentDate;
	private String appointmentDate;

	/**
	 * 预约开始时间
	 */
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
	private Date appointmentStart;

	/**
	 * 预约结束时间
	 */
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
	private Date appointmentEnd;

	/**
	 * 预约时长 单位：分钟
	 */
	private Integer appointmentTimeLength;

	/**
	 * 预约备注
	 */
	private String remark;

	/**
	 * 预约状态 1：预约正常，2：改约，3：取消预约，4：已到诊，5：已就诊（治疗中），6：已结算 7 到诊患者变更 8 walk in变更 9 已爽约
	 * 以上为全部的预约状态，电子病历用到的状态为：1预约正常 4已到诊 5已就诊（治疗中/已接诊） 6已结算（已接诊）
	 */
	private Integer appointmentStatus;

	/**
	 * 电子病历状态 1待写 2书写中 3已签名提交
	 */
	private Integer emrStatus;

	/**
	 * 转诊预约1/ 非转诊预约0
	 */
	private Integer isReferral;

	/**
	 * 是否被转诊 1未转诊 2已转诊 default:1
	 **/
	private Integer beReferral;

	/**
	 * 指定医生1/ 不指定指定医生0
	 */
	private Integer isResourceAlter;

	/**
	 * 重大治疗 1是 / 0 否
	 */
	private Integer majorTreatment;
	/**
	 * 机构ID
	 */
	private String organizationId;
	/**
	 * 租户ID
	 */
	private String tenantId;
}
