package co.com.pascal516.model.guest;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Guest {
    private String id;
    private String name;
    private String contactNumber;
}
