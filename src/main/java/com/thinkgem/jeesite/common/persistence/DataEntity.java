package com.thinkgem.jeesite.common.persistence;

import java.util.Date;

import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.sys.entity.User;

public abstract class DataEntity<T> extends BaseEntity<T>{

	private static final long serialVersionUID = 1L;
	
	protected String remarks;	// 备注
	protected User createBy;	// 创建者
	protected Date createDate;	// 创建日期
	protected User updateBy;	// 更新者
	protected Date updateDate;	// 更新日期
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
	
	
	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public DataEntity(String id) {
		super(id);
	}

	@Override
	public void preInsert() {
		/**
		 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
		 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
		 */
		if(!this.isNewRecord) {//表示新建记录
			setId(IdGen.uuid());
		}
	}

	@Override
	public void preUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
