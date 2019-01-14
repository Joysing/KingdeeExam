package com.kingdee.exam.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class TestPaperTestsList {

	private Integer testpaperId;

	private List<Integer> questionBankId;

}
