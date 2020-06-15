package jp.te4a.spring.boot.myapp12;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor; 
import lombok.Data; import lombok.NoArgsConstructor; 
@Data
@NoArgsConstructor
public class BookForm{ 
	private Integer id ;
	@NotNull
	@Size(min = 3)
	@TestValid(param = "abc")
	private String title;
	@Writter(ok = "東北タロウ")
	@Size(min = 3, max = 20)
	private String writter;
	private String publisher;
	@Min(0)
	private Integer price;
	
	} 



