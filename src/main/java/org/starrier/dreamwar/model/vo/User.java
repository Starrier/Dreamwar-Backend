package org.starrier.dreamwar.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.starrier.dreamwar.model.entity.Role;
import org.starrier.dreamwar.utils.annotation.IsMobile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * The first refactor on 2019/1/7.
 * 1. refactor the class of role
 * 2. use annotation framework,lombok and spring jpa.
 *
 * @author Starrier
 * @date 2018/6/5.
 */
@Accessors(chain = true)
@Data
@Entity
@Table(name = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserBO Entity")
public class User implements Serializable {

    /**
     * SerialVersionUID,serial version.
     *
     * @param serialVersionUID
     * */
    private static final long serialVersionUID = 7698862379923111158L;
    /**
     * USERNAME_MIN_SIZE.
     * */
    private static final Integer USERNAME_MIN_SIZE = 2;
    /**
     * USERNAME_MAX_SIZE.
     * */
    private static final Integer USERNAME_MAX_SIZE = 20;
    /**
     * PASSWORD_MIN_SIZE.
     * */
    private static final Integer PASSWORD_MIN_SIZE = 5;
    /**
     * EMAIL_MAX_SIZE.
     * */
    private static final Integer EMAIL_MAX_SIZE = 50;
    /**
     * AVATAR_LENGTH.
     * */
    private static final Integer AVATAR_LENGTH = 200;


    /**
     * @param id, Long type,this is the unique identify in user.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * {@code username} should be the unique,while there are no other
     *                  uniquely identifiable user login property exists,
     *                  and sometime maybe called {@param nickname}.
     * */
    @ApiModelProperty(value = "username")
    @NotEmpty(message = "username should not be null")
    @Size(min = 2, max = 20)
    @Column(name = "username")
    private String username;

    /**
     * @param password attributes managed by the corresponding {@param username}
     * */
    @ApiModelProperty(value = "user's password")
    @Length(min = 5,
            message = "Password should be more than 5 characters at least")
    @Column(name = "password")
    @NotEmpty(message = "password do not allow empty")
    private String password;

    /**
     * @param status of {@param user},it is used to indicate whether
     *               the current {@param user} is available or not.
     *               it {@value} of {@code status} is 1,
     *               the current user could be use,
     *               otherwise,disabled.
     * */
    @Column
    @ApiModelProperty(value = "user's status")
    private int status;

    /**
     * email String.
     * UserBO will login in via given authority.
     * */
    @Email(message = "Please provide a valid Email")
    @Size(max = 50)
    @NotEmpty(message = "email must add")
    @Column
    @ApiModelProperty(value = "email")
    private String email;

    /**
     *
     * warning: this {@link IsMobile} annotation unavailable up to now.
     *           and this annotation will be {@link Deprecated} in the
     *           future version.
     *
     * mobile String.
     * <p>
     *     {@code
     *     @IsMobile(message = "Please provider a valid Mobile")
     *     this method has been deprecated,because of the unexpected exception.
     *     }
     * </p>
     *
     * @since version 0.0.1-SNAPSHOT
     * */
    @IsMobile
    @Column
    @ApiModelProperty(value = "mobile")
    private String mobile;

    /**
     * avatar String.
     * */
    @Column(length = 200)
    @ApiModelProperty(value = "avatar")
    private String avatar;

    /**
     * createTime Date.
     * */
    @Column
    @ApiModelProperty(value = "createTime")
    private Date createTime;

    /**
     * updateTime Date.
     * */
    @Column
    @ApiModelProperty(value = "updateTime")
    private Date updateTime;



    /**
     * @param roles.
     * */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;


    /**
     * @param validateCode. Long type.
     * */
    @Transient
    private Long validateCode;



    /**
     * UserBO's NoArgsConstructor，{@link NoArgsConstructor} can get more details.
     *
     * <p>
     *     <pre>
     *         {@code
     *         public UserBO(){}
     *         }
     *     </pre>
     * </p>
     *
     * And this method has been defined with annotation @NoArgsConstructor.
     * When the explicit definition exists at the same time as the annotation,
     * the explicit definition will override the effect of annotation,that is ,
     * the annotation fails.
     * */
}
