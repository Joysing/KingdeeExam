package com.kingdee.exam.entity.vo;

import com.kingdee.exam.entity.Options;
import com.kingdee.exam.entity.QuestionBank;
import com.kingdee.exam.voj.model.Problem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionBankVo extends QuestionBank {

	private List<Options> options;

	private boolean ifCorrect;

	private Problem codingProblem;

}
