package pl.patrykkawula.servicesupply.picture;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Picture {
    private String name;
    private String fileName;
}