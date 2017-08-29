package hu.bbs.collections;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author bvarga and created on 2017. 08. 29..
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TestComplexVo {
	private long id;
	private String address;
	private BigDecimal salary;
}
