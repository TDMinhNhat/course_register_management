import {useDispatch, useSelector} from "react-redux";
import type {RootType} from "../stores/stores.ts";

export default function LoginPage() {

    const language: object = useSelector((state: RootType): object => state.language.login_page);

    return (
        <div className={"container-fluid w-100 h-100"}>
            <div className={"position-absolute top-50 start-50 translate-middle"}>

            </div>
        </div>
    )
}