https://vertabelo.com/blog/the-doctor-will-see-you-soon-a-data-model-for-a-medical-appointment-booking-app/

March 1, 2017 - 10 minutes read
Example er diagrams
A Data Model for a Medical Appointment Booking App
Shantanu Kher



Booking a doctor’s appointment using an online app is an innovation that simplifies the entire process. Let’s dive into the data model behind an appointment booking app.

Why use an app? It makes it easier for people to find the doctors of their choice, letting them see the doctor’s professional records and patient reviews. When someone finds a doctor they like, they can book an appointment with them without leaving the app. An app can also help doctors keep their patients’ waiting times as short as possible, help them schedule their patients, and enable them to keep an eye on patients’ online reviews.
Medical Appointment App Requirements

In brief, we expect that our app will:

    Allow patients to search for doctors of various specializations (family doctor, cardiologist, podiatrist, etc.) by location.
    Show an ordered list of doctors based on their years of experience, their distance from the patient’s location, their patient recommendations, and their review indexes (patients’ collective rating of bedside manner, waiting time, staff, etc.)
    Show doctors’ initial and follow-up consulting fees.
    Capture and display doctors’ profiles, including details about their degrees, certifications, internships, and past and current affiliations with hospitals.
    Record reviews about doctors from app users. This review will gives a thorough preview of doctors and their staff to other app users.

And don’t forget the app’s unique selling point: showing upcoming available appointments and allowing users to book one.
Categorizing App Requirements

Basically, we can divide the app’s requirements into these four areas:

    Managing Doctors’ Data – Doctors can register and enter all their details.
    Managing Doctors’ OPD (Outpatient Department) and Clinic Details – Doctors (or their staff) can log details about their clinic or OPD schedule and availability.
    Managing Client and Review Data – Users can register and enter their basic details. They can also post reviews about doctors.
    Managing Appointments – Users can search for doctors based on certain criteria.

Let’s look at these areas individually.
Managing Doctors’ Data

Doctors can register with the app by filling in certain mandatory details, but the appointment booking feature is enabled only after they complete their full profile. This includes their qualifications (professional degrees, certifications/specializations, and internships), and their past and current affiliations with hospitals and healthcare service providers.

The tables shown below manage this information.

Managing Doctors’ Data

The doctor table stores elementary details about doctors, which they enter during registration. The columns in this table are:

    id – A unique number that the app assigns to doctors during registration.
    first_name – Doctor’s first name.
    last_name – Doctor’s last name.
    professional_statement – A detailed overview of the doctor’s qualifications, experience, their professional motto, etc. This information is entered by the doctor and is displayed on each doctor’s profile page.
    practicing_from – The date the doctor started practicing medicine. This has deep significance, as the app will derive its experience rating for each doctor based on the information in this column.

The specialization table holds all existing medical specializations like orthopedic, neurologist, dentist, etc. A doctor can have more than one specialization; in fact, it’s pretty common for a doctor to specialize in related fields. For example, a neurologist can also be a psychiatrist; a gynecologist can be an endocrinologist, and so on. Therefore, the doctor_specialization table allows a many-to-many relationship between the doctor and specialization tables. The attributes on these two tables are self-explanatory.

The qualification table stores details about doctors’ education and professional qualifications, including degrees, certifications, research papers, seminars, ongoing training, etc. To facilitate the various types of qualification details, I have given these fields quite generic names:

    id – The primary key of the table.
    doctor_id – References the doctor table and relates the doctor with the qualification.
    qualification_name – Signifies the name of the degree, certification, research paper, etc.
    institute_name – The institution that issued the qualification to the doctor. This can be a university, a medical institution, an international association of medical practitioners, etc.
    procurement_year – The date when the qualification was obtained or awarded.

The hospital_affiliation table keeps information about doctors’ affiliations with hospitals and healthcare service providers. This data is only for display on a doctor’s profile and has no significance in the appointment booking feature. OPD (Outpatient Department) details are entered separately and will be handled later in this article.

This table’s columns are:

    id – The primary key of the table.
    doctor_id – References the doctor table and links the doctor to the affiliated hospital.
    hospital_name – The affiliated hospital’s name.
    city and country – The city and country where the hospital is located. These address columns do not play any role in the app’s search function; they are only for display on the doctor’s profile.
    start_date – When the doctor’s affiliation with the hospital commenced.
    end_date – When the affiliation ended. It is nullable because current affiliations will not have an end date.

Managing Doctors’ OPD/ Clinic Details

The information in this section is entered by doctors (or their staff) and plays a significant role in the app’s search and booking functionalities.

Managing Doctors’ OPD/ Clinic Details

The office table holds information about the Outpatient Department of the hospitals doctors are affiliated with as well as their own clinics (i.e. offices or surgeries). The columns in this table are:

    id – The primary key of this table.
    doctor_id – References the doctor table and indicates the relevant doctor.
    hospital_affiliation_id –Signifies the hospital where the doctor is available for OPD. Since the column is applicable to OPDs but not clinics, it is nullable.
    time_slot_per_client_in_min – Stores an amount of time (in minutes) allotted for consultations. The number of minutes is entered by doctors based on their experience. This column helps the app determine the next available slot. Note that this number is not a guarantee of appointment length, but it helps to minimize patient wait times if they use the app to book an appointment.
    first_consultation_fee – The fee charged by the doctor for an initial visit. This may seem unimportant, but it’s very important for the search function; fee is a very common filter criterion.
    followup_consultation_fee – Many doctors charge less for a follow-up visit than for an initial consultation. This column stores the follow-up consultation cost.
    street_address – The address of the hospital OPD or clinic.
    city, state and country –The city, state and country where the hospital or clinic is located.
    zip – The postal code where the clinic or hospital is located. Often, people search for doctors in nearby areas using a postal code, so this field will be important for the app’s search function.

Why Is There a Separate “office” Table When OPD Details Can Easily Be Tracked in the “hospital_affiliation” Table?

Three reasons:

    A doctor might be affiliated with a hospital for one aspect of their work (i.e. performing surgeries) but not for others (i.e. seeing walk-in patients). We may lose such affiliations if we attempt to maintain office details in the hospital_affiliation table only.
    Many doctors are not affiliated with hospitals, but have their own clinics or offices. We need to store information for these doctors as well.
    A doctor may have several offices in different locations, or may work at several branches of a hospital. If the doctor is only shown as being affiliated with one hospital location, we can lose some information. That is the reason we maintain separate address details.

The office_doctor_availability table stores doctors’ OPD/ clinic availability in terms of time slots (say 2 hours in the morning and 4 hours in the evening). Splitting up the day this way is pretty common, so having an additional table to store availability slots makes sense. Plus, doctors can work more than one OPD shift. The columns for this table are:

    id – The primary key of the table.
    office_id – References the “office” table.
    day_of_week – The day of the week, i.e. Monday, Tuesday, etc. This allows doctors to have different availabilities for different days (weekends vs. weekdays, for example).
    start_time – When the doctor is ready for the first patient.
    end_time – When the final appointment or shift is scheduled to end.
    is_available – Allows doctors to mark their availability for particular days or time slots. This column is initialized with a ‘Y’ as default and is updated to an ‘N’ when doctors mark their unavailability.
    reason_of_unavailablity – Many doctors prefer to disclose why they are unavailable or must cancel an appointment. This helps to build a transparent relationship between doctors and their patients. Since it is optional, I have kept this as nullable column.

The in_network_insurance table stores insurance information. In many countries, medical services are very costly and health insurance is mandatory. In such cases, this table contains the details about what insurance companies are fully accepted at the hospital OPD or clinic.
Managing Client and Review Data

For a patient, registering for the app requires very little information. From here on, I will use ‘client’ rather than ‘user’ or ‘patient’.

Managing Client and Review Data

The client_account table stores basic details for clients. These details are captured at the time of registration. The columns in this table are:

    id – A unique number assigned to each client.
    first_name – The client’s first name.
    last_name – The client’s last name.
    contact_number – The client’s phone number, preferably a mobile number, to which appointment information can be sent. This is also the number where the client can be contacted by the doctor’s office staff.
    email – The client’s email address. The app may send appointment reminders to clients.

The client_review table not only offers feedback (i.e. client reviews) for doctors, but it also helps potential clients to choose doctors. It is an integral component of this app. Columns for this table are:

    id – The primary key of this table.
    user_account_id – Signifies which user is submitting the review.
    doctor_id – The doctor being reviewed.
    is_review_anonymous – If the client’s name will be published with the review or not. This is a security feature for clients.
    wait_time_rating – This number column holds a rating ranging from 1 (worst) to 10 (best). It reflects the client’s opinion of how long they waited to see the doctor.
    bedside_manner_rating –Stores the client’s opinion of the doctor’s bedside manner (i.e. if the doctor is kind, compassionate, communicates well, etc.)
    overall_rating – Client’s rating of their general experience with the doctor.
    review – Clients can give their detailed feedback here.
    is_doctor_recommended – This indicator column states whether the client would recommend the doctor.
    review_date – When the review was submitted.

Managing Appointments

This section is the foremost USP (Unique Selling Point) for this app, as it allows clients to check the availability of various doctors and book an appointment.

Managing Appointments

The appointment table holds appointment details for clients. Its columns include:

    id – A unique number is assigned to each appointment. This number is referenced elsewhere.
    user_account_id – Which client is booking the appointment.
    office_id – Signifies which doctor and which hospital OPD or clinic is involved in the appointment.
    probable_start_time – This is a timestamp column that holds the probable start time of the appointment. Medical appointments’ start times are usually probable rather than absolute.
    actual_end_time – The actual end time of the consultation. Initially this column is blank, as many factors can influence when an appointments ends. Therefore, this is a nullable column.
    appointment_status_id – This is referenced from the appointment_status table, and it signifies the current status of the appointment. Possible values for status are “active”, “canceled”, and “complete”. Initially the status would be “active”. It would become “complete” once the appointment is done. It will become “canceled” if the client cancels their appointment.
    appointment_taken_date – The date when appointment was made.
    app_booking_channel_id – The channel through which an appointment was booked. There are multiple channels through which appointments are made: through the app, by calling the hospital, by calling the doctor or their office, etc.

See the Complete Data Model


What Would You Add?

What else can be added to this app and this data model? Share your views in the comments.

    Tags:
    database design
    database model
    SQL
    example data model
    example ER diagram
    example ERD diagram
    template

Subscribe to our newsletter Join our weekly newsletter to be
notified about the latest posts.
You may also like
Example er diagrams
A Data Model to Keep Track of Your Most Precious Possession
Read more
Example er diagrams
Improving Our Online Job Portal Data Model
Read more
Example er diagrams
A Database Model for Gallery or Museum Management
Read more
go to top
Site Footer
Quick links
Vertabelo Blog
Documentation
FAQ
Features
Pricing
Academy
Support
If you have any questions or you need our help, you can contact us through our
Support site
Follow Us
Copyright ©2013-2018 Vertabelo SA All rights reserved
Terms of Service
Privacy Policy
Imprint
Investor relations
