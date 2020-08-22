package ke.co.hello

import android.os.Parcel
import android.os.Parcelable
import com.example.hello3.SerializedName
import com.google.gson.annotations.SerializedName

data class Course(@SerializedName("course_id") var courseId: String, @SerializedName("course_name") var courseName: String, @SerializedName("course_code") var courseCode: String, @SerializedName("instructor") var instructor: String, @SerializedName("description") var description: String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(courseId)
        parcel.writeString(courseName)
        parcel.writeString(courseCode)
        parcel.writeString(instructor)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Course> {
        override fun createFromParcel(parcel: Parcel): Course {
            return Course(parcel)
        }

        override fun newArray(size: Int): Array<Course?> {
            return arrayOfNulls(size)
        }
    }
}
