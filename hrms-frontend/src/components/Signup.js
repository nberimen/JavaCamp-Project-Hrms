import React from 'react'
import { Formik, Form } from 'formik'
import TextInput from '../utilities/customFormControl/TextInput'
import * as Yup from 'yup'
const Signup = () => {

    const initialValues = {
        firstName: "",
        lastName: "",
        email: "",
        password: "",
        confirmPassword: ""
    }

    const validationSchema = Yup.object({
        firstName: Yup.string()
            .min(2, "Çok Kısa!")
            .max(25, "Çok Uzun!")
            .required("İsim Alanı Boş Bırakılamaz."),
        lastName: Yup.string()
            .min(2, "Çok Kısa")
            .max(20, "Çok Uzun!")
            .required("Soyisim Alanı Boş Bırakılamaz."),
        email: Yup.string()
            .email('Geçersiz E-posta!')
            .required("E-posta Alanı Boş Bırakılamaz."),
        password: Yup.string()
            .min(6, 'Şifre en az 6 karakterden oluşmalı!')
            .required("Şifre Alanı Boş Bırakılamaz."),
        confirmPassword: Yup.string()
            .oneOf([Yup.ref('password'), null], 'Şifre uyuşmuyor! ')
            .required("Şifre Tekrarı Alanı Boş Bırakılamaz."),
    });

    return (
        <Formik
            initialValues={initialValues}
            validationSchema={validationSchema}
            onSubmit={values => {
                console.log(values)
            }}
        >
            {formik => (
                <div>
                    <h1 className="my-4 font-weight-bold-display-4" >Kaydol</h1>
                    {/*console.log(formik.values)*/}
                    <Form>
                        <TextInput
                            label="İsim"
                            name="firstName"
                            type="text"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />
                        <TextInput
                            label="Soyisim"
                            name="lastName"
                            type="text"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />
                        <TextInput
                            label="E-posta"
                            name="email"
                            type="email"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />
                        <TextInput
                            label="Şifre"
                            name="password"
                            type="password"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />
                        <TextInput
                            label="Şifre Tekrarı"
                            name="confirmPassword"
                            type="password"
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                        />

                        <button className="btn btn-dark mt-3" type="submit">Kaydol</button>
                        <button className="btn btn-danger mt-3 ml-3" type="reset">Reset</button>

                    </Form>
                </div>
            )

            }
        </Formik>
    )
}

export default Signup
