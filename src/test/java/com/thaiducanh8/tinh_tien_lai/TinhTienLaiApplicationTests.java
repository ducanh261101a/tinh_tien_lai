package com.thaiducanh8.tinh_tien_lai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TinhTienLaiApplicationTests {
	TinhTienLai tinhTienLai = new TinhTienLai();

	@Test
	void contextLoads() throws Exception {
		long result = tinhTienLai.tinh_tien_lai(100000, 12, true);
		assertThat(result).isEqualTo(25500000);
	}

	class TinhTienLai {
		public long tinh_tien_lai(long money, int time, boolean deposit_type) throws Exception {
			if (money < 0 || money > 1000000000) {
				throw new Exception("so tien khong hop le");
			}
			if (time < 0 || time > 24) {
				throw new Exception("thoi gian khong hop le");
			}
			if (deposit_type) {
				if (time <= 3) {
					return (long) (money + money * 0.0034 * time);
				}
				if (time <= 6) {
					return (long) (money + money * 0.0042 * time);
				}
				if (time <= 12) {
					return (long) (money + money * 0.0056 * time);
				}
				if (time <= 24) {
					return (long) (money + money * 0.0062 * time);
				}
			} else {
				if (time <= 3) {
					return (long) (money + money * 0.003 * time);
				}
				if (time <= 6) {
					return (long) (money + money * 0.004 * time);
				}
				if (time <= 12) {
					return (long) (money + money * 0.005 * time);
				}
				return (long) (money + money * 0.006 * time);
			}
			return 0;
		}
	}
}
