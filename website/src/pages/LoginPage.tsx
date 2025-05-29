import {useState} from "react";
import {useSelector} from "react-redux";
import type {RootType} from "../stores/stores.ts";
import type {FormEvent} from "react";

export default function LoginPage() {

    const language: object = useSelector((state: RootType): object => state.language.login_page);

    const [account, setAccount] = useState<string>("");
    const [password, setPassword] = useState<string>("");

    const handleLogin = (event: FormEvent) => {
        event.preventDefault();
    }

    return (
        <div className={"container-fluid w-100 h-100"}>
            <form className={"position-absolute w-25 top-50 start-50 translate-middle border rounded p-4 bg-white"}>
                <div className={"w-100 text-center"}>
                    <h1>{language.title}</h1>
                    <p>{language.subtitle}</p>
                </div>
                <div className={"w-100 mt-4"}>
                    <div className={"w-100 d-flex flex-column"}>
                        <label className={"form-label"}>{language.account.label}:</label>
                        <input className={"form-control"} placeholder={language.account.placeholder} required={true} onChange={(event) => setAccount(event.target.value)}/>
                    </div>
                    <div className={"w-100 d-flex flex-column mt-3"}>
                        <label className={"form-label"}>{language.password.label}:</label>
                        <input className={"form-control"} placeholder={language.password.placeholder} required={true} type={"password"} onChange={(event) => setPassword(event.target.value)}/>
                    </div>
                    <div className={"w-100 d-flex flex-row mt-3"}>
                        <label>{language.reset_password.label}</label>
                        <a className={"ms-1"} href={"#"}>{language.reset_password.link}</a>
                    </div>
                    <div className={"w-100 d-flex flex-column align-items-center justify-content-center mt-3"}>
                        <button className={"btn btn-primary"} onClick={(event) => handleLogin(event)}>{language.button.label}</button>
                    </div>
                </div>
            </form>
        </div>
    )
}