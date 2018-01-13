package org.oldcode.javaweb.model.account;

public class User {
    public int id;
    public boolean superuser;
    public boolean staff;
    public boolean active;
    public String name;
    public String email;

    public static User byId(int id) {
        return null;
    }

    public static User byName(String name) {
        return null;
    }
}

/*
func (u *User) String() string {
	return fmt.Sprintf("<id:%d username:%s email:%s pw:%s>", u.Id, u.Username, u.Email, u.Password)
}

func GetUserById(id int) (*User, error) {
	row := db.DB.QueryRow(`
SELECT id, password, is_superuser, username, first_name, last_name,
email, is_staff, is_active
FROM account WHERE id=$1`, id)

	u := &User{}
	err := row.Scan(
		&u.Id,
		&u.Password,
		&u.Is_superuser,
		&u.Username,
		&u.First_name,
		&u.Last_name,
		&u.Email,
		&u.Is_staff,
		&u.Is_active)

	if err != nil {
		return nil, err
	}
	return u, nil
}

func GetUserByName(username string) (*User, error) {
	row := db.DB.QueryRow(`
SELECT id, password, is_superuser, username, first_name, last_name,
email, is_staff, is_active
FROM account WHERE username=$1`, username)

	u := &User{}
	err := row.Scan(
		&u.Id,
		&u.Password,
		&u.Is_superuser,
		&u.Username,
		&u.First_name,
		&u.Last_name,
		&u.Email,
		&u.Is_staff,
		&u.Is_active)

	if err != nil {
		return nil, err
	} else {
		return u, nil
	}
}

func PasswordMatch(u *User, formpassword string) bool {
	lg.Log.Printf("user:%s", u)
	lg.Log.Printf("u-pw:%s f-pw:%s", u.Password, formpassword)
	return u.Password == formpassword
}

func AuthUser(w http.ResponseWriter, r *http.Request, username string, password string) bool {
	u, err := GetUserByName(username)
	sess := session.Manager.Load(r)
	if err == nil {
		lg.Log.Printf("user email:%s", u.Email)
		if PasswordMatch(u, password) {
			lg.Log.Printf("AuthUser MATCH")
			err := sess.PutInt(w, "user_id", u.Id)
			if err != nil {
				panic(err)
			}
			return true
		} else {
			lg.Log.Printf("AuthUser NO MATCH")
		}
	}

	lg.Log.Printf("AuthUser err:%s", err)
	sess.PopInt(w, "user_id")
	sess.PopString(w, "user_username")
	return false
}

func (u *User) SaveDir() (sd string) {
	sd = fmt.Sprintf("%s/account/%s_%s", config.Get("work_dir"), u.Id, u.Username)
	return
}
*/


